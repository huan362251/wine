package com.wine.manage.commodity.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Author LIUHUAN
 * @Description 商品描述
 * @Date Created by  2019/3/27 22:31
 **/
@Data
public class CommodityDTO {

    //商品主键
    private String commodityBaseinfoId;

    //商品详情主键
    private String commodityDetailId;

    //商品名称
    @NotNull(message = "商品名称不能为空")
    @Length(min = 1,max = 50)
    private String commodityName;

    //商品代码
    @NotNull(message = "商品代码不能为空")
    @Length(min = 1,max = 10)
    private String commodityCode;

    //商品种类
    @NotNull(message = "商品种类不能为空")
    @Length(min = 1,max = 3)
    private String commodityKind;

    //商品库存
    @NotNull(message = "商品库存不能为空")
    @Length(min = 0,max = 3)
    private int commodityQuantity;

    //商品重量
    private BigDecimal commodityWeight;

    //商品产地
    private String commodityOrigin;

    //商品容量
    private String commodityCapacity;

    //商品度数
    private int commodityDegree;

    //商品包装
    private String commodityPack;

    //香型
    private String orderType;


}
