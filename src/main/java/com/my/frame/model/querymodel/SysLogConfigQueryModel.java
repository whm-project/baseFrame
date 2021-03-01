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
public class SysLogConfigQueryModel extends BaseQueryModel implements Serializable {
    private String logId;

    private String modelName;

    private String operType;

    private String flag;

    private Date ts;

    private static final long serialVersionUID = 1L;
}