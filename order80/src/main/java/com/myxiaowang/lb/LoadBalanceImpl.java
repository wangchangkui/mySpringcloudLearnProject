package com.myxiaowang.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现自己的负载均衡算法
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月17日 19:55:00
 */
@Component
public class LoadBalanceImpl implements LoadBalance {
    /**
     * 当前所选择的注册服务
     */
    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger(0);


    /**
     *  自选的时候轮询获取示例
     * @return 当前所选的下标
     */
    public int getAndIncrement(){
        int current;
        int next;
        while (true){
            current = ATOMIC_INTEGER.get();
            next = current >= 214748367 ? 0 : current + 1;
            if(ATOMIC_INTEGER.compareAndSet(current,next)){
                return current;
            }
        }
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int next = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(next);
    }
}
