package com.test.sample.service.impl;

import com.test.sample.domain.EntpOrder;
import com.test.sample.model.EntpOrderUpdateStatusRequest;
import com.test.sample.service.UpdateOrderService;
import com.test.sample.service.UpdateOrderTransactionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UpdateOrderServiceImpl implements UpdateOrderService {

    @Resource
    UpdateOrderTransactionService updateOrderTransactionService;

    @Override
    public Boolean updateOrder(EntpOrderUpdateStatusRequest request) {

        String orderNo = request.getOrderNo();
        EntpOrder entpOrder = new EntpOrder();
        entpOrder.setOrderNo(orderNo);
        entpOrder.setUpdatedBy(request.getOperatorRealname());

        try {
            updateOrderTransactionService.cancelOrder(entpOrder);
        } catch (Exception e) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }



}
