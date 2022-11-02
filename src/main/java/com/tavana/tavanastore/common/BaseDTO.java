package com.tavana.tavanastore.common;

import lombok.Data;
import java.util.Date;

@Data
public class BaseDTO {
    private Long id;

    private Integer version;

    private Date createdDate;

    private String createdBy;

    private Date lastModifiedDate;

    private String lastModifiedBy;




}
