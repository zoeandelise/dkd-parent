package com.dkd.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkd.manage.mapper.TaskCollectMapper;
import com.dkd.manage.domain.TaskCollect;
import com.dkd.manage.service.ITaskCollectService;

/**
 * 工单按日统计Service业务层处理
 * 
 * @author itheima
 * @date 2025-05-06
 */
@Service
public class TaskCollectServiceImpl implements ITaskCollectService 
{
    @Autowired
    private TaskCollectMapper taskCollectMapper;

    /**
     * 查询工单按日统计
     * 
     * @param id 工单按日统计主键
     * @return 工单按日统计
     */
    @Override
    public TaskCollect selectTaskCollectById(Long id)
    {
        return taskCollectMapper.selectTaskCollectById(id);
    }

    /**
     * 查询工单按日统计列表
     * 
     * @param taskCollect 工单按日统计
     * @return 工单按日统计
     */
    @Override
    public List<TaskCollect> selectTaskCollectList(TaskCollect taskCollect)
    {
        return taskCollectMapper.selectTaskCollectList(taskCollect);
    }

    /**
     * 新增工单按日统计
     * 
     * @param taskCollect 工单按日统计
     * @return 结果
     */
    @Override
    public int insertTaskCollect(TaskCollect taskCollect)
    {
        return taskCollectMapper.insertTaskCollect(taskCollect);
    }

    /**
     * 修改工单按日统计
     * 
     * @param taskCollect 工单按日统计
     * @return 结果
     */
    @Override
    public int updateTaskCollect(TaskCollect taskCollect)
    {
        return taskCollectMapper.updateTaskCollect(taskCollect);
    }

    /**
     * 批量删除工单按日统计
     * 
     * @param ids 需要删除的工单按日统计主键
     * @return 结果
     */
    @Override
    public int deleteTaskCollectByIds(Long[] ids)
    {
        return taskCollectMapper.deleteTaskCollectByIds(ids);
    }

    /**
     * 删除工单按日统计信息
     * 
     * @param id 工单按日统计主键
     * @return 结果
     */
    @Override
    public int deleteTaskCollectById(Long id)
    {
        return taskCollectMapper.deleteTaskCollectById(id);
    }
}
