package com.wine.common.verify;

import java.util.List;

public class Verify {

    /**
     * 校验当前list为空
     */
    public static boolean isNullList(List<?> list){
        if(null == list || list.size()==0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 校验当前list非空
     * @param list
     * @return
     */
    public static boolean isNotNullList(List<?> list){
        if(null == list || list.size() ==0){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /**
     * 校验当前对象是否为空
     * @param obj
     * @return
     */
    public static boolean isNull(Object obj){

        if(null == obj ){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;

    }
}
