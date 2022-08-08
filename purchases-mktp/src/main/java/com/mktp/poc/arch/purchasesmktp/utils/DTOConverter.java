package com.mktp.poc.arch.purchasesmktp.utils;

import com.mktp.poc.arch.purchasesmktp.model.CustomerProduct;
import com.mktp.poc.arch.purchasesmktp.web.CustomerProductDTO;

import java.util.Optional;

public class DTOConverter {

    private DTOConverter(){}

    public static CustomerProductDTO getCustomerProductDTO(CustomerProduct customerProduct){
        CustomerProductDTO objReturn = new CustomerProductDTO();

        Optional<CustomerProduct> customerProductOptional = Optional.ofNullable(customerProduct);
        if (!customerProductOptional.isPresent())
            return objReturn;

        objReturn.setCustomerIdentifier(Optional.ofNullable(customerProduct.getIdCustomer())
                .map(Optional::of)
                .map(e -> e.get().getCustomerIdentifier())
                .orElse(""));
        objReturn.setProductName(Optional.ofNullable(customerProduct.getIdProduct())
                .map(Optional::of)
                .map(e -> e.get().getProductName())
                .orElse(""));
        objReturn.setDate(Optional.ofNullable(customerProduct.getDate())
                .map(Optional::of)
                .map(x -> x.get().toString())
                .orElse(""));
        objReturn.setQuantity(customerProduct.getQuantity());
        objReturn.setSupplierIdentifier(Optional.ofNullable(customerProduct.getIdSupplier())
                .map(Optional::of)
                .map(e -> e.get().getSupplierIdentifier())
                .orElse(""));
        return objReturn;
    }

}
