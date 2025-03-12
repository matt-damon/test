package com.test.sample.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.gdsz.framework.jdbc.service.impl.BasicServiceImpl;
import com.test.sample.domain.EntpOrder;
import com.test.sample.mapper.EntpOrderMapper;
import com.test.sample.model.EntpOrderUpdateStatusRequest;
import com.test.sample.service.UpdateOrderTransactionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateOrderTransactionServiceImpl extends BasicServiceImpl<EntpOrderMapper, EntpOrder> implements UpdateOrderTransactionService {


    /**          同个方法内
     *  外部 --->[test ->  cancelOrder]
     *
     * @param request
     * @return
     */

    @Override
    public Boolean test(EntpOrderUpdateStatusRequest request) {
        String orderNo = request.getOrderNo();
        EntpOrder entpOrder = new EntpOrder();
        entpOrder.setOrderNo(orderNo);
        entpOrder.setUpdatedBy(request.getOperatorRealname());

        try {
            this.cancelOrder(entpOrder);//this
        } catch (Exception e) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Boolean cancelOrder(EntpOrder order) {
        //修改订单状态
        LambdaUpdateWrapper<EntpOrder> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(EntpOrder::getOrderNo, order.getOrderNo());
        updateWrapper.set(EntpOrder::getUpdatedBy, order.getUpdatedBy());

        boolean updated = update(updateWrapper);
        if (updated) {
            throw new RuntimeException("更新失败");
        }
        return Boolean.TRUE;
    }


}
