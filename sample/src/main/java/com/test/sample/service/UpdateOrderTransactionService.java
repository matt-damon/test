package com.test.sample.service;

import com.test.sample.domain.EntpOrder;
import com.test.sample.model.EntpOrderUpdateStatusRequest;

public interface UpdateOrderTransactionService {


    Boolean test(EntpOrderUpdateStatusRequest request);

    Boolean cancelOrder(EntpOrder order);

}
