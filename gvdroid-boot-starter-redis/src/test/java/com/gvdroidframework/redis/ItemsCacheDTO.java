package com.gvdroidframework.redis;



import java.io.Serializable;
import java.util.List;

/**
 * 商品缓存对象，供前端对比
 */
public class ItemsCacheDTO implements Serializable {

    private static final long serialVersionUID = -5926505322747006400L;

    /**
     * 服务ID
     */
    Long serviceId;

    /**
     * 缓存子对象
     */
    List<ItemsCacheSubDTO> cacheSubList;

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public List<ItemsCacheSubDTO> getCacheSubList() {
        return cacheSubList;
    }

    public void setCacheSubList(List<ItemsCacheSubDTO> cacheSubList) {
        this.cacheSubList = cacheSubList;
    }
}
