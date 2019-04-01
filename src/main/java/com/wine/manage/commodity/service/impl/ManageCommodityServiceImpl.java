package com.wine.manage.commodity.service.impl;

import com.wine.common.code.CodeMsg;
import com.wine.common.message.ResponseDTO;
import com.wine.common.verify.Verify;
import com.wine.manage.commodity.dao.ManageCommodityDao;
import com.wine.manage.commodity.dto.CommodityDTO;
import com.wine.manage.commodity.service.ManageCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author LIUHUAN
 * @Description
 * @Date Created by  2019/3/27 23:02
 **/
@Service
public class ManageCommodityServiceImpl implements ManageCommodityService {

    @Autowired
    private ManageCommodityDao dao;

    @Override
    public ResponseDTO insertManageCommodity(CommodityDTO dto) throws Exception {
        ResponseDTO responseDTO = new ResponseDTO();
        //校验参数
        if(Verify.isNull(dto)){
            CodeMsg.PARAM_IS_NULL.setResponse(responseDTO);
            return responseDTO;
        }
        //新增商品基础信息
        dao.insertManageCommodityBaseInfo(dto);
        //新增商品详情
        dao.insertManageCommodityDetail(dto);

        return responseDTO;
    }

    @Override
    public ResponseDTO deleteManageCommodity(String commodityBaseinfoId) throws Exception {
        ResponseDTO responseDTO = new ResponseDTO();
        //校验参数
        if(StringUtils.isEmpty(commodityBaseinfoId)){
            CodeMsg.PARAM_IS_NULL.setResponse(responseDTO);
            return responseDTO;
        }
        //删除商品详情
        dao.deleteCommodityDetail(commodityBaseinfoId);
        //删除商品基础信息
        dao.deleteCommodityBaseInfo(commodityBaseinfoId);

        return responseDTO;
    }
}
