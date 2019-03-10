package com.wine.common.aop;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.javassist.ClassClassPath;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.javassist.bytecode.AttributeInfo;
import org.apache.ibatis.javassist.bytecode.CodeAttribute;
import org.apache.ibatis.javassist.bytecode.LocalVariableAttribute;
import org.apache.ibatis.javassist.bytecode.MethodInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;


/**
 * 入参、出参aop切面
 */
@Aspect
@Component
public class LogParamAop {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //拦截controller下的所有方法
    @Pointcut("execution(* com.wine.project..controller..*.*(..))")
    private void controllerMethod(){}

    @Around("controllerMethod()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {

        String message = "aop["
                + point.getSignature().getDeclaringTypeName()
                + point.getSignature().getName()
                + "]";

        String requestStr = getRequestparam(point);

        logger.info(message + "start.输入参数" + requestStr);

        long startTime = System.currentTimeMillis();

        Object result = null;

        try{
            result = point.proceed();
        }catch (Exception e){
            throw e;
        }finally {
            long handleTime = System.currentTimeMillis()-startTime;// 开始时间
            String responseStr  = result == null ? "否" : JSON.toJSONString(result);
            StringBuffer endString = new StringBuffer(100);
            endString.append(message).append("end.");
            endString.append("耗时（" + handleTime + "ms）");
            endString.append("输出参数：").append(responseStr);

            logger.info(endString.toString());
        }

        return result;
    }

    /**
     * @Description: 获取请求参数
     * @param point
     * @return
     */
    private String getRequestparam(ProceedingJoinPoint point){
        //为什么这两个不从同一个地方获取？
        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
        //获取方法参数
        Object[] methodArgs = point.getArgs();

        String[] paramNames = null;

        String requestStr = "";

        try {
            paramNames = getFieldsName(className, methodName);
            requestStr = logParam(paramNames, methodArgs);
        } catch (Exception e) {
            requestStr = "获取参数失败";
        }
        return requestStr;
    }

    /**
     * 获取方法参数名称，基本没有看懂
     * @param className
     * @param methodName
     * @return
     * @throws Exception
     */
    private String[] getFieldsName(String className,String methodName) throws Exception {

        Class clazz = Class.forName(className);

        String clazzName = clazz.getName();

        ClassPool pool = ClassPool.getDefault();

        ClassClassPath classPath  = new ClassClassPath(clazz);

        pool.insertClassPath(classPath);

        CtClass ctClass = pool.get(clazzName);

        CtMethod ctMethod  = ctClass.getDeclaredMethod(methodName);

        MethodInfo methodInfo = ctMethod.getMethodInfo();

        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();

        LocalVariableAttribute attribute = (LocalVariableAttribute)codeAttribute.getAttribute(LocalVariableAttribute.tag);

        if(attribute == null){
            return null;
        }

        String[] paramsArgsName = new String[ctMethod.getParameterTypes().length];

        int pos = Modifier.isStatic(ctMethod.getModifiers()) ? 0 : 1;

        for(int i = 0; i<paramsArgsName.length; i++){
            paramsArgsName[i] = attribute.variableName(i + pos);
        }

        return paramsArgsName;
    }

    private String logParam(String[] paramsArgsName,Object[] paramsArgsValue){
        if(null == paramsArgsName || paramsArgsName.length == 0){
            return "";
        }

        StringBuffer buffer = new StringBuffer();
        for (int i=0;i<paramsArgsValue.length;i++){
            //参数名
            String name = paramsArgsName[i];
            //参数值
            Object value = paramsArgsValue[i];
            buffer.append(name +" = ");
            if(isPrimite(value.getClass())){
                buffer.append(value + "  ,");
            }else {
                buffer.append(value.toString() + "  ,");
            }
        }
        return buffer.toString();
    }

    /**
     * 判断是否为基本类型：包括String
     * @param clazz clazz
     * @return  true：是;     false：不是
     */
    private boolean isPrimite(Class<?> clazz){
        if (clazz.isPrimitive() || clazz == String.class){
            return true;
        }else {
            return false;
        }
    }

}
