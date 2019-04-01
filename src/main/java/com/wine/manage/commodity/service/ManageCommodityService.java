package com.wine.manage.commodity.service;

import com.wine.common.message.ResponseDTO;
import com.wine.manage.commodity.dto.CommodityDTO;

/**
 * @Author LIUHUAN
 * @Description
 * @Date Created by  2019/3/27 23:01
 **/
public interface ManageCommodityService {

    /**
     * 新增商品
     * @param dto 商品详情DTO
     * @return
     */
    ResponseDTO insertManageCommodity(CommodityDTO dto) throws Exception;

    /**
     *
     * @param commodityBaseinfoId 商品主键
     * @return
     * @throws Exception
     */
    ResponseDTO deleteManageCommodity(String commodityBaseinfoId) throws Exception;
}
