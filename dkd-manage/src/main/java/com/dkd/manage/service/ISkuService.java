package com.dkd.manage.service;

import java.util.List;
import com.dkd.manage.domain.Sku;
import com.dkd.manage.domain.vo.ChannelVo;

/**
 * 商品管理Service接口
 * 
 * @author itheima
 * @date 2025-04-20
 */
public interface ISkuService 
{
    /**
     * 查询商品管理
     * 
     * @param skuId 商品管理主键
     * @return 商品管理
     */
    public Sku selectSkuBySkuId(Long skuId);

    /**
     * 查询商品管理列表
     * 
     * @param sku 商品管理
     * @return 商品管理集合
     */
    public List<Sku> selectSkuList(Sku sku);

    /**
     * 新增商品管理
     * 
     * @param sku 商品管理
     * @return 结果
     */
    public int insertSku(Sku sku);

    /**
     * 修改商品管理
     * 
     * @param sku 商品管理
     * @return 结果
     */
    public int updateSku(Sku sku);

    /**
     * 批量删除商品管理
     * 
     * @param skuIds 需要删除的商品管理主键集合
     * @return 结果
     */
    public int deleteSkuBySkuIds(Long[] skuIds);

    /**
     * 删除商品管理信息
     * 
     * @param skuId 商品管理主键
     * @return 结果
     */
    public int deleteSkuBySkuId(Long skuId);

    /**
     * 批量插入商品管理
     * @param skuList
     * @return
     */
    public int batchInsertSku(List<Sku> skuList);

    /**
     * 根据商品管理主键查询商品管理
     * 
     * @param skuIds 商品管理主键集合
     * @return 商品管理集合
     */
    public List<Sku> selectSkuBySkuIds(Long[] skuIds);

    /**
     * 根据售货机内部编号查询售货机货道
     */
    List<ChannelVo> selectChannelVoListByInnerCode(String innerCode);
}
