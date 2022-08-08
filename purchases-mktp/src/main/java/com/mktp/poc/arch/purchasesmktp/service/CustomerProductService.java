package com.mktp.poc.arch.purchasesmktp.service;

import com.mktp.poc.arch.purchasesmktp.web.CustomerProductDTO;

import java.util.List;

public interface CustomerProductService {

    List<CustomerProductDTO> getListOfOrders();

}
