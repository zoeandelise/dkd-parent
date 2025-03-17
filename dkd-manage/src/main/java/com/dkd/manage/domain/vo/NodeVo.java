package com.dkd.manage.domain.vo;

import com.dkd.manage.domain.Node;
import com.dkd.manage.domain.Partner;
import com.dkd.manage.domain.Region;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NodeVo extends Node {
    //设备数量
    private Integer vmCount;
    //区域id
    private Region region;
    //合作商id
    private Partner partner;
}
