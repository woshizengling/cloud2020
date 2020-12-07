package com.simpler.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author simpler
 * @program: springcloud_study
 * @description:
 * @create 2020/12/07 20:24
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);

}
