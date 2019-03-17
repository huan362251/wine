package com.wine.project.user.dto;

import com.wine.common.message.ResponseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RoleResDTO extends ResponseDTO {

    private List<Role> list;

}
