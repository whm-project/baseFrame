package com.my.frame.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

/**
* Created by Mybatis Generator on 2019/11/28
*/
@Table(name = "sys_log")
@Data
@NoArgsConstructor
@Accessors(chain = true)
@AllArgsConstructor(staticName = "set")
public class SysLog implements Serializable {
    @Id
    @Column(name = "LOG_ID", updatable = false)
    private String logId;

    @Column(name = "TS")
    private Date ts;

    @Column(name = "OPERATE_TYPE")
    private String operateType;

    @Column(name = "USER_CD")
    private String userCd;

    @Column(name = "USER_NM")
    private String userNm;

    @Column(name = "MODEL_NAME")
    private String modelName;

    /**
     * 0或空 pc日志，1：用水户日志
     * 
     * @mbg.generated
     */
    @Column(name = "FLAG")
    private String flag;

    @Column(name = "NT")
    private String nt;

    private static final long serialVersionUID = 1L;
}