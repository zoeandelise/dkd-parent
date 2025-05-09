package com.dkd.manage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dkd.common.annotation.Log;
import com.dkd.common.core.controller.BaseController;
import com.dkd.common.core.domain.AjaxResult;
import com.dkd.common.enums.BusinessType;
import com.dkd.manage.domain.TaskCollect;
import com.dkd.manage.service.ITaskCollectService;
import com.dkd.common.utils.poi.ExcelUtil;
import com.dkd.common.core.page.TableDataInfo;

/**
 * 工单按日统计Controller
 * 
 * @author itheima
 * @date 2025-05-06
 */
@RestController
@RequestMapping("/manage/collect")
public class TaskCollectController extends BaseController
{
    @Autowired
    private ITaskCollectService taskCollectService;

    /**
     * 查询工单按日统计列表
     */
    @PreAuthorize("@ss.hasPermi('manage:collect:list')")
    @GetMapping("/list")
    public TableDataInfo list(TaskCollect taskCollect)
    {
        startPage();
        List<TaskCollect> list = taskCollectService.selectTaskCollectList(taskCollect);
        return getDataTable(list);
    }

    /**
     * 导出工单按日统计列表
     */
    @PreAuthorize("@ss.hasPermi('manage:collect:export')")
    @Log(title = "工单按日统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TaskCollect taskCollect)
    {
        List<TaskCollect> list = taskCollectService.selectTaskCollectList(taskCollect);
        ExcelUtil<TaskCollect> util = new ExcelUtil<TaskCollect>(TaskCollect.class);
        util.exportExcel(response, list, "工单按日统计数据");
    }

    /**
     * 获取工单按日统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:collect:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(taskCollectService.selectTaskCollectById(id));
    }

    /**
     * 新增工单按日统计
     */
    @PreAuthorize("@ss.hasPermi('manage:collect:add')")
    @Log(title = "工单按日统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TaskCollect taskCollect)
    {
        return toAjax(taskCollectService.insertTaskCollect(taskCollect));
    }

    /**
     * 修改工单按日统计
     */
    @PreAuthorize("@ss.hasPermi('manage:collect:edit')")
    @Log(title = "工单按日统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TaskCollect taskCollect)
    {
        return toAjax(taskCollectService.updateTaskCollect(taskCollect));
    }

    /**
     * 删除工单按日统计
     */
    @PreAuthorize("@ss.hasPermi('manage:collect:remove')")
    @Log(title = "工单按日统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(taskCollectService.deleteTaskCollectByIds(ids));
    }
}
