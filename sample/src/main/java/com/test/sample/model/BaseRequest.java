package com.test.sample.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huangxuezhong
 * @date 2024/1/18 10:38
 * @since 1.0.0
 */

@Data
@Schema(description = "请求基本参数")
public class BaseRequest implements Serializable {

    @Schema(description = "操作人id")
    @Size(max = 32)
    private String operatorId;

    @Schema(description = "操作人角色 1：采购员 2：客户经理 3：单位员工。 4：系统。")
    private Integer operatorRole;

    @Schema(description = "操作人电话")
    @Size(max = 32)
    private String operatorPhone;

    @Schema(description = "操作人姓名")
    @Size(max = 32)
    private String operatorRealname;

    @Schema(description = "操作时间")
    // @NotNull(message = "操作时间 不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date operatorTime = new Date();

    @Schema(description = "操作人账号")
    @Size(max = 32)
    private String operatorUsername;
}
