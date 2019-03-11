package com.wine.common.message;

import com.wine.common.code.CodeMsg;

public class ResponseDTO {

    private String resultCode = CodeMsg.SUCCESS.getCode();

    private String resultMessage = CodeMsg.SUCCESS.getMessage();

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
