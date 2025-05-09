package com.dkd.manage.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dkd.common.annotation.Excel;
import com.dkd.common.core.domain.BaseEntity;

/**
 * 工单按日统计对象 tb_task_collect
 * 
 * @author itheima
 * @date 2025-05-06
 */
public class TaskCollect extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long userId;

    /** 当日工单完成数 */
    @Excel(name = "当日工单完成数")
    private Long finishCount;

    /** 当日进行中的工单数 */
    @Excel(name = "当日进行中的工单数")
    private Long progressCount;

    /** 当日取消工单数 */
    @Excel(name = "当日取消工单数")
    private Long cancelCount;

    /** 汇总的日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "汇总的日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date collectDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setFinishCount(Long finishCount) 
    {
        this.finishCount = finishCount;
    }

    public Long getFinishCount() 
    {
        return finishCount;
    }
    public void setProgressCount(Long progressCount) 
    {
        this.progressCount = progressCount;
    }

    public Long getProgressCount() 
    {
        return progressCount;
    }
    public void setCancelCount(Long cancelCount) 
    {
        this.cancelCount = cancelCount;
    }

    public Long getCancelCount() 
    {
        return cancelCount;
    }
    public void setCollectDate(Date collectDate) 
    {
        this.collectDate = collectDate;
    }

    public Date getCollectDate() 
    {
        return collectDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("finishCount", getFinishCount())
            .append("progressCount", getProgressCount())
            .append("cancelCount", getCancelCount())
            .append("collectDate", getCollectDate())
            .toString();
    }
}
