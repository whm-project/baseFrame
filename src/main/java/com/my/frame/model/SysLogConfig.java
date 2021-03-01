package com.my.frame.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

/**
* Created by Mybatis Generator on 2019/11/28
*/
@Table(name = "sys_log_config")
@Data
@NoArgsConstructor
@Accessors(chain = true)
@AllArgsConstructor(staticName = "set")
public class SysLogConfig implements Serializable {
    @Id
    @Column(name = "log_id", updatable = false)
    private String logId;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "oper_type")
    private String operType;

    private String flag;

    private Date ts;

    private static final long serialVersionUID = 1L;
}