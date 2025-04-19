package com.dkd.manage.service;

import java.util.List;
import com.dkd.manage.domain.Partner;

/**
 * 
 * @author itheima
 */
public interface IPartnerService 
{
    /**
     * 
     */
    public Partner selectPartnerById(Long id);

    /**
     *
     */
    public List<Partner> selectPartnerList(Partner partner);

    /**
     * 
     * @return 结果
     */
    public int insertPartner(Partner partner);

    /**
     * 
     * @return 结果
     */
    public int updatePartner(Partner partner);

    /**
     * 
     * @return 结果
     */
    public int deletePartnerByIds(Long[] ids);

    /**
     * 
     * @return 结果
     */
    public int deletePartnerById(Long id);
}
