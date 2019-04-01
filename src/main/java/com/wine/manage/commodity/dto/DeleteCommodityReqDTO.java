package com.wine.manage.commodity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author LIUHUAN
 * @Description
 * @Date Created by  2019/4/1 22:52
 **/
@Data
public class DeleteCommodityReqDTO {

    //商品主键
    @NotNull
    private String commodityBaseinfoId;
}
