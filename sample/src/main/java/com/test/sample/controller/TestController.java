package com.test.sample.controller;

import com.gdsz.framework.base.bean.ResponseData;
import com.test.sample.model.EntpOrderUpdateStatusRequest;
import com.test.sample.service.UpdateOrderService;
import com.test.sample.service.UpdateOrderTransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Tag(name = "测试", description ="TestController")
@RequestMapping("/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {


    @Resource
    private UpdateOrderService updateOrderService;


    @Operation(summary ="取消订单")
    @GetMapping("/cancelOrder")
    public ResponseData<Boolean> cancelOrder(EntpOrderUpdateStatusRequest request) {
        return ResponseData.resp(() -> updateOrderService.updateOrder(request));
    }

    private void testClass() {

    }

    public static void main(String[] args) {

    }
}
