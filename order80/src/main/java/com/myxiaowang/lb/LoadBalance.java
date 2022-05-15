package com.myxiaowang.lb;

import org.springframework.cloud.client.ServiceInstance;
import java.util.List;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月17日 19:53:00
 */
public interface LoadBalance {


    /**
     * 获取注册中心所有的注册节点
     * @param serviceInstances 注册中心所有的注册节点
     * @return ServiceInstance
     */
   ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
