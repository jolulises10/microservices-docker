package com.mktp.poc.arch.purchasesmktp;

import com.mktp.poc.arch.purchasesmktp.model.CustomerProduct;
import com.mktp.poc.arch.purchasesmktp.repo.CustomerProductRepository;
import com.mktp.poc.arch.purchasesmktp.service.CustomerProductService;
import com.mktp.poc.arch.purchasesmktp.service.CustomerProductServiceImpl;
import com.mktp.poc.arch.purchasesmktp.web.CustomerProductController;
import com.mktp.poc.arch.purchasesmktp.web.CustomerProductDTO;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ServiceUnitTestConfig {

    @Bean(name = "with_purchases")
    public CustomerProductController getCustomerProductControllerWithPurchases(){
        CustomerProductService customerProductService = Mockito.mock(CustomerProductService.class);
        Mockito.when(customerProductService.getListOfOrders()).thenReturn(getListOfOrders());
        CustomerProductController customerProductController = new CustomerProductController(customerProductService);

        return customerProductController;
    }

    @Bean(name = "with_no_purchases")
    public CustomerProductController getCustomerProductControllerEmpty(){
        CustomerProductRepository customerProductRepo = Mockito.mock(CustomerProductRepository.class);
        Mockito.when(customerProductRepo.findAll()).thenReturn(getCustomerProductIterator());
        CustomerProductService customerProductService = new CustomerProductServiceImpl(customerProductRepo);
        CustomerProductController customerProductController = new CustomerProductController(customerProductService);

        return customerProductController;
    }

    private List<CustomerProductDTO> getListOfOrders(){
        //TODO fill in this method from a file?
        List<CustomerProductDTO> listReturn = new ArrayList<>();
        listReturn.add(new CustomerProductDTO());
        listReturn.add(new CustomerProductDTO());
        listReturn.add(new CustomerProductDTO());
        return listReturn;
    }

    private Iterable<CustomerProduct> getCustomerProductIterator(){
        Iterable<CustomerProduct> returnObj = new ArrayList<>();
        return returnObj;
    }
}
