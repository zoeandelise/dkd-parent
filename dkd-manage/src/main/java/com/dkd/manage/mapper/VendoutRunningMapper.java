package com.dkd.manage.mapper;

import java.util.List;
import com.dkd.manage.domain.VendoutRunning;

/**
 * 出货流水Mapper接口
 * 
 * @author itheima
 * @date 2025-05-06
 */
public interface VendoutRunningMapper 
{
    /**
     * 查询出货流水
     * 
     * @param id 出货流水主键
     * @return 出货流水
     */
    public VendoutRunning selectVendoutRunningById(Long id);

    /**
     * 查询出货流水列表
     * 
     * @param vendoutRunning 出货流水
     * @return 出货流水集合
     */
    public List<VendoutRunning> selectVendoutRunningList(VendoutRunning vendoutRunning);

    /**
     * 新增出货流水
     * 
     * @param vendoutRunning 出货流水
     * @return 结果
     */
    public int insertVendoutRunning(VendoutRunning vendoutRunning);

    /**
     * 修改出货流水
     * 
     * @param vendoutRunning 出货流水
     * @return 结果
     */
    public int updateVendoutRunning(VendoutRunning vendoutRunning);

    /**
     * 删除出货流水
     * 
     * @param id 出货流水主键
     * @return 结果
     */
    public int deleteVendoutRunningById(Long id);

    /**
     * 批量删除出货流水
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVendoutRunningByIds(Long[] ids);
}
