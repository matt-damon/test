package com.test.sample.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EntpOrderUpdateStatusRequest extends BaseRequest {

    @Schema(description = "订单号")
    private String orderNo;

}
