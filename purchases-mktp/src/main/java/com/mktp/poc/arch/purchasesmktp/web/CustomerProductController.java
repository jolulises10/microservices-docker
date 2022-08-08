package com.mktp.poc.arch.purchasesmktp.web;

import com.mktp.poc.arch.purchasesmktp.service.CustomerProductService;
import com.mktp.poc.arch.purchasesmktp.utils.NoContentException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/purchases")
public class CustomerProductController {

    private final CustomerProductService customerProductService;

    public CustomerProductController(CustomerProductService customerProductService){
        this.customerProductService = customerProductService;
    }

    @GetMapping
    public List<CustomerProductDTO> getPurchasesList(){

        return customerProductService.getListOfOrders();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(NoContentException.class)
    public String returnNoContent(NoContentException exception){
        return exception.getMessage();
    }

}
