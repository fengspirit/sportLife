package com.sports.life.controller;

import com.sports.life.service.OrderService;
import com.sports.life.utils.DataResult;
import com.sports.life.vo.reqVO.order.OrderDetailAddVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Api(tags = "订单模块")
public class OrderController {


    final OrderService orderService;

    /**
     * 创建订单
     * @param order
     * @return
     */
    @PostMapping("/order/create")
    @ApiOperation(value = "创建新的订单")
    public DataResult<String> create(@RequestBody OrderDetailAddVO order) {
        //创建订单
        orderService.create(order);
        return DataResult.success("订单提交完成");
    }
}

