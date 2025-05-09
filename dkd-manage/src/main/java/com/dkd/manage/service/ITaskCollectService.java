package com.dkd.manage.service;

import java.util.List;
import com.dkd.manage.domain.TaskCollect;

/**
 * 工单按日统计Service接口
 * 
 * @author itheima
 * @date 2025-05-06
 */
public interface ITaskCollectService 
{
    /**
     * 查询工单按日统计
     * 
     * @param id 工单按日统计主键
     * @return 工单按日统计
     */
    public TaskCollect selectTaskCollectById(Long id);

    /**
     * 查询工单按日统计列表
     * 
     * @param taskCollect 工单按日统计
     * @return 工单按日统计集合
     */
    public List<TaskCollect> selectTaskCollectList(TaskCollect taskCollect);

    /**
     * 新增工单按日统计
     * 
     * @param taskCollect 工单按日统计
     * @return 结果
     */
    public int insertTaskCollect(TaskCollect taskCollect);

    /**
     * 修改工单按日统计
     * 
     * @param taskCollect 工单按日统计
     * @return 结果
     */
    public int updateTaskCollect(TaskCollect taskCollect);

    /**
     * 批量删除工单按日统计
     * 
     * @param ids 需要删除的工单按日统计主键集合
     * @return 结果
     */
    public int deleteTaskCollectByIds(Long[] ids);

    /**
     * 删除工单按日统计信息
     * 
     * @param id 工单按日统计主键
     * @return 结果
     */
    public int deleteTaskCollectById(Long id);
}
