package com.wine.common.code;

import com.wine.common.message.ResponseDTO;

public enum CodeMsg {
    SUCCESS("000000","成功");

    private String code;

    private String message;

    CodeMsg(String code,String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResponse(ResponseDTO responseDTO){
        responseDTO.setResultCode(this.code);
        responseDTO.setResultMessage(this.message);
    }

}
