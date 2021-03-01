package com.my.frame.model.querymodel;

import com.my.base.BaseQueryModel;
import java.io.Serializable;
import java.util.Date;
import lombok.*;
import lombok.experimental.Accessors;

/**
* Created by Mybatis Generator on 2019/11/28
*/
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class SysLogQueryModel extends BaseQueryModel implements Serializable {
    private String logId;

    private Date ts;

    private String operateType;

    private String userCd;

    private String userNm;

    private String modelName;

    /**
     * 0或空 pc日志，1：用水户日志
     * 
     * @mbg.generated
     */
    private String flag;

    private String nt;

    private static final long serialVersionUID = 1L;
}