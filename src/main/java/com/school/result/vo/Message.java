package com.school.result.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "这是返回信息用的对象")
public class Message {
    @ApiModelProperty(value = "这是携带的信息")
    private String msg;
    @ApiModelProperty(value = "这是状态码")
    private String code;
    private Map<String, Object> data;

}
