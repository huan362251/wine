package com.wine.common.message;

import com.wine.common.code.CodeMsg;
import lombok.Data;

@Data
public class ResponseDTO {

    private String resultCode = CodeMsg.SUCCESS.getCode();

    private String resultMessage = CodeMsg.SUCCESS.getMessage();

}
