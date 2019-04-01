package com.wine.manage.commodity.dao;

import com.wine.manage.commodity.dto.CommodityDTO;

/**
 * @Author LIUHUAN
 * @Description 商品管理
 * @Date Created by  2019/3/27 22:38
 **/
public interface ManageCommodityDao {

    //添加商品
    void insertManageCommodityBaseInfo(CommodityDTO dto);

    //新增商品详情
    void insertManageCommodityDetail(CommodityDTO dto);

    //删除商品详情描述
    void deleteCommodityDetail(String commodityBaseinfoId);

    //删除商品基础信息表
    void deleteCommodityBaseInfo(String commodityBaseinfoId);
}
