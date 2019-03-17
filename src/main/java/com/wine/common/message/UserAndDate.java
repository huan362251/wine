package com.wine.common.message;

import lombok.Data;

import java.util.Date;

@Data
public class UserAndDate {

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;
}
