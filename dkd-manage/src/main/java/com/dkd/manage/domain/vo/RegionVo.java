package com.dkd.manage.domain.vo;

import com.dkd.manage.domain.Region;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RegionVo extends Region {

    private Integer nodeCount;
}
