package com.dkd.manage.service.impl;

import java.util.List;
import com.dkd.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkd.manage.mapper.VendoutRunningMapper;
import com.dkd.manage.domain.VendoutRunning;
import com.dkd.manage.service.IVendoutRunningService;

/**
 * 出货流水Service业务层处理
 * 
 * @author itheima
 * @date 2025-05-06
 */
@Service
public class VendoutRunningServiceImpl implements IVendoutRunningService 
{
    @Autowired
    private VendoutRunningMapper vendoutRunningMapper;

    /**
     * 查询出货流水
     * 
     * @param id 出货流水主键
     * @return 出货流水
     */
    @Override
    public VendoutRunning selectVendoutRunningById(Long id)
    {
        return vendoutRunningMapper.selectVendoutRunningById(id);
    }

    /**
     * 查询出货流水列表
     * 
     * @param vendoutRunning 出货流水
     * @return 出货流水
     */
    @Override
    public List<VendoutRunning> selectVendoutRunningList(VendoutRunning vendoutRunning)
    {
        return vendoutRunningMapper.selectVendoutRunningList(vendoutRunning);
    }

    /**
     * 新增出货流水
     * 
     * @param vendoutRunning 出货流水
     * @return 结果
     */
    @Override
    public int insertVendoutRunning(VendoutRunning vendoutRunning)
    {
        vendoutRunning.setCreateTime(DateUtils.getNowDate());
        return vendoutRunningMapper.insertVendoutRunning(vendoutRunning);
    }

    /**
     * 修改出货流水
     * 
     * @param vendoutRunning 出货流水
     * @return 结果
     */
    @Override
    public int updateVendoutRunning(VendoutRunning vendoutRunning)
    {
        vendoutRunning.setUpdateTime(DateUtils.getNowDate());
        return vendoutRunningMapper.updateVendoutRunning(vendoutRunning);
    }

    /**
     * 批量删除出货流水
     * 
     * @param ids 需要删除的出货流水主键
     * @return 结果
     */
    @Override
    public int deleteVendoutRunningByIds(Long[] ids)
    {
        return vendoutRunningMapper.deleteVendoutRunningByIds(ids);
    }

    /**
     * 删除出货流水信息
     * 
     * @param id 出货流水主键
     * @return 结果
     */
    @Override
    public int deleteVendoutRunningById(Long id)
    {
        return vendoutRunningMapper.deleteVendoutRunningById(id);
    }
}
