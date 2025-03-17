package com.dkd.manage.domain.vo;

import com.dkd.manage.domain.Partner;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class PartnerVo extends Partner {
    private Integer nodeCount;
}
