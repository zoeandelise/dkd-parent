package com.dkd.manage.mapper;

import java.util.List;
import com.dkd.manage.domain.Partner;

/**
 * 合作商信息管理Mapper接口
 * 
 * @author itheima
 * @date 2025-03-17
 */
public interface PartnerMapper 
{
    /**
     * 查询合作商信息管理
     * 
     * @param id 合作商信息管理主键
     * @return 合作商信息管理
     */
    public Partner selectPartnerById(Long id);

    /**
     * 查询合作商信息管理列表
     * 
     * @param partner 合作商信息管理
     * @return 合作商信息管理集合
     */
    public List<Partner> selectPartnerList(Partner partner);

    /**
     * 新增合作商信息管理
     * 
     * @param partner 合作商信息管理
     * @return 结果
     */
    public int insertPartner(Partner partner);

    /**
     * 修改合作商信息管理
     * 
     * @param partner 合作商信息管理
     * @return 结果
     */
    public int updatePartner(Partner partner);

    /**
     * 删除合作商信息管理
     * 
     * @param id 合作商信息管理主键
     * @return 结果
     */
    public int deletePartnerById(Long id);

    /**
     * 批量删除合作商信息管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePartnerByIds(Long[] ids);
}
