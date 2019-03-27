package com.wine.project.user.dto;

import com.wine.common.message.ResponseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author LIUHUAN
 * @Description 用户详情表
 * @Date Created by  2019/3/18 21:35
 **/
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserMessageDTO extends ResponseDTO {

    //主键
    private String userMessageId;

    //用户主键
    private String userId;

    //手机号
    private String iphone;

    //身份证号
    private String idNumber;

}
