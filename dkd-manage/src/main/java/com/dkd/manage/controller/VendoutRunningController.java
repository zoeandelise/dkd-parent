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
import com.dkd.manage.domain.VendoutRunning;
import com.dkd.manage.service.IVendoutRunningService;
import com.dkd.common.utils.poi.ExcelUtil;
import com.dkd.common.core.page.TableDataInfo;

/**
 * 出货流水Controller
 * 
 * @author itheima
 * @date 2025-05-06
 */
@RestController
@RequestMapping("/manage/running")
public class VendoutRunningController extends BaseController
{
    @Autowired
    private IVendoutRunningService vendoutRunningService;

    /**
     * 查询出货流水列表
     */
    @PreAuthorize("@ss.hasPermi('manage:running:list')")
    @GetMapping("/list")
    public TableDataInfo list(VendoutRunning vendoutRunning)
    {
        startPage();
        List<VendoutRunning> list = vendoutRunningService.selectVendoutRunningList(vendoutRunning);
        return getDataTable(list);
    }

    /**
     * 导出出货流水列表
     */
    @PreAuthorize("@ss.hasPermi('manage:running:export')")
    @Log(title = "出货流水", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VendoutRunning vendoutRunning)
    {
        List<VendoutRunning> list = vendoutRunningService.selectVendoutRunningList(vendoutRunning);
        ExcelUtil<VendoutRunning> util = new ExcelUtil<VendoutRunning>(VendoutRunning.class);
        util.exportExcel(response, list, "出货流水数据");
    }

    /**
     * 获取出货流水详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:running:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(vendoutRunningService.selectVendoutRunningById(id));
    }

    /**
     * 新增出货流水
     */
    @PreAuthorize("@ss.hasPermi('manage:running:add')")
    @Log(title = "出货流水", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VendoutRunning vendoutRunning)
    {
        return toAjax(vendoutRunningService.insertVendoutRunning(vendoutRunning));
    }

    /**
     * 修改出货流水
     */
    @PreAuthorize("@ss.hasPermi('manage:running:edit')")
    @Log(title = "出货流水", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VendoutRunning vendoutRunning)
    {
        return toAjax(vendoutRunningService.updateVendoutRunning(vendoutRunning));
    }

    /**
     * 删除出货流水
     */
    @PreAuthorize("@ss.hasPermi('manage:running:remove')")
    @Log(title = "出货流水", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(vendoutRunningService.deleteVendoutRunningByIds(ids));
    }
}
