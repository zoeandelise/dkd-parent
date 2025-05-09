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
import com.dkd.manage.domain.TaskDetails;
import com.dkd.manage.service.ITaskDetailsService;
import com.dkd.common.utils.poi.ExcelUtil;
import com.dkd.common.core.page.TableDataInfo;

/**
 * 工单详情Controller
 * 
 * @author itheima
 * @date 2025-04-28
 */
@RestController
@RequestMapping("/manage/taskDeatils")
public class TaskDetailsController extends BaseController
{
    @Autowired
    private ITaskDetailsService taskDetailsService;

    /**
     * 查询工单详情列表
     */
    @PreAuthorize("@ss.hasPermi('manage:taskDeatils:list')")
    @GetMapping("/list")
    public TableDataInfo list(TaskDetails taskDetails)
    {
        startPage();
        List<TaskDetails> list = taskDetailsService.selectTaskDetailsList(taskDetails);
        return getDataTable(list);
    }

    /**
     * 导出工单详情列表
     */
    @PreAuthorize("@ss.hasPermi('manage:taskDeatils:export')")
    @Log(title = "工单详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TaskDetails taskDetails)
    {
        List<TaskDetails> list = taskDetailsService.selectTaskDetailsList(taskDetails);
        ExcelUtil<TaskDetails> util = new ExcelUtil<TaskDetails>(TaskDetails.class);
        util.exportExcel(response, list, "工单详情数据");
    }

    /**
     * 获取工单详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:taskDeatils:query')")
    @GetMapping(value = "/{detailsId}")
    public AjaxResult getInfo(@PathVariable("detailsId") Long detailsId)
    {
        return success(taskDetailsService.selectTaskDetailsByDetailsId(detailsId));
    }

    /**
     * 新增工单详情
     */
    @PreAuthorize("@ss.hasPermi('manage:taskDeatils:add')")
    @Log(title = "工单详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TaskDetails taskDetails)
    {
        return toAjax(taskDetailsService.insertTaskDetails(taskDetails));
    }

    /**
     * 修改工单详情
     */
    @PreAuthorize("@ss.hasPermi('manage:taskDeatils:edit')")
    @Log(title = "工单详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TaskDetails taskDetails)
    {
        return toAjax(taskDetailsService.updateTaskDetails(taskDetails));
    }

    /**
     * 删除工单详情
     */
    @PreAuthorize("@ss.hasPermi('manage:taskDeatils:remove')")
    @Log(title = "工单详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{detailsIds}")
    public AjaxResult remove(@PathVariable Long[] detailsIds)
    {
        return toAjax(taskDetailsService.deleteTaskDetailsByDetailsIds(detailsIds));
    }

    /**
     * 查看工单补货详情
     */
    @PreAuthorize("@ss.hasPermi('manage:taskDetails:list')")
    @GetMapping(value = "/byTaskId/{taskId}")
    public AjaxResult byTaskId(@PathVariable("taskId") Long taskId) {
        TaskDetails taskDetailsParam = new TaskDetails();
        taskDetailsParam.setTaskId(taskId);
        return success(taskDetailsService.selectTaskDetailsList(taskDetailsParam));
    }
}
