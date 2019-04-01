package com.wine.manage.commodity.controller;

import com.wine.common.code.CodeMsg;
import com.wine.common.message.ResponseDTO;
import com.wine.manage.commodity.dto.CommodityDTO;
import com.wine.manage.commodity.dto.DeleteCommodityReqDTO;
import com.wine.manage.commodity.service.ManageCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author LIUHUAN
 * @Description
 * @Date Created by  2019/3/27 23:08
 **/
@RestController
@RequestMapping(value = "/manageCommodity")
public class ManageCommodityController {

    @Autowired
    private ManageCommodityService service;

    /**
     * 新增商品
     * @param dto
     * @return
     */
    @PostMapping("/insertManageCommodity.do")
    public ResponseDTO insertManageCommodity(@RequestBody(required = true)@Valid CommodityDTO dto){
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            service.insertManageCommodity(dto);
        }catch (Exception e){
            CodeMsg.EXCEPTION.setResponse(responseDTO);
            e.printStackTrace();
        }

        return responseDTO;
    }

    @PostMapping("/deleteManageCommodity.do")
    public ResponseDTO deleteManageCommodity(@RequestBody(required = true)@Valid DeleteCommodityReqDTO dto){
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            service.deleteManageCommodity(dto.getCommodityBaseinfoId());
        } catch (Exception e) {
            CodeMsg.EXCEPTION.setResponse(responseDTO);
            e.printStackTrace();
        }
        return responseDTO;
    }
}
