package com.myxiaowang.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.myxiaowang.lb.LoadBalance;
import com.myxiaowang.pojo.Payment;
import com.myxiaowang.util.Reslut.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月17日 13:50:00
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalance loadBalance;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${request.url}")
    private String url;

    @GetMapping("/getOrder/{id}")
    public ResponseResult<Payment> getOrderInfo( @PathVariable Integer id) {
        String forObject = restTemplate.getForObject(url + "/payment/findById/" + id, String.class);
        JSONObject jsonObject = JSON.parseObject(forObject);
        if(Objects.isNull(jsonObject.get("data"))){
            return ResponseResult.error("订单不存在");
        }
        Payment data = JSON.parseObject(jsonObject.get("data").toString(), Payment.class);
        return  ResponseResult.success(data);
    }

    @PostMapping("/create")
    public ResponseResult<String> saveOrder(@RequestBody Payment payment) {
        // 使用restTemplate 去调用订单服务，增加订单
        String forObject = restTemplate.postForObject(url + "/payment/save", payment, String.class);
        JSONObject jsonObject = JSON.parseObject(forObject);
        Boolean data = JSON.parseObject(jsonObject.get("data").toString(), Boolean.class);
        if (data.equals(true)) {
            return ResponseResult.success("订单保存成功");
        }
        return ResponseResult.success("订单保存失败");
    }

    @GetMapping("/lb/{id}")
    public String getPaymentLb(@PathVariable Integer id) {
        // 获取所有可用的服务
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVER");
        if (instances == null || instances.size() <= 0) {
            return "没有可用的服务";
        }
        // 加载自己的负载均衡算法
        ServiceInstance instance = loadBalance.instance(instances);
        System.out.println(instance.getHost()+":"+instance.getPort());
        // 从自己的负载均衡算法中获取一个服务实例
        String forObject = restTemplate.getForObject("http://"+instance.getHost() + ":" + instance.getPort() +"/payment/findById/" + id, String.class);
        JSONObject jsonObject = JSON.parseObject(forObject);
        if(Objects.isNull(jsonObject.get("data"))){
            return "订单不存在";
        }
        Payment data = JSON.parseObject(jsonObject.get("data").toString(), Payment.class);
        return "订单详情：" + JSON.toJSONString(data);
    }


}
