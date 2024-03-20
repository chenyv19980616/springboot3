package com.atguigu.boot3.ssm.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author : chenyv
 * @since : 2024-03-20 23:12
 */
@Data
public class EmpReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 8627717440583161208L;

    /**
     * 员工id
     */
    private Long employeeId;

    /**
     * 页数
     */
    private Integer pageIndex = 1;

    /**
     * 分页数据大小
     */
    private Integer pageSize = 10;
}
