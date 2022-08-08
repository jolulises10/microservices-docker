package com.mktp.poc.arch.purchasesmktp.service;

import com.mktp.poc.arch.purchasesmktp.model.CustomerProduct;
import com.mktp.poc.arch.purchasesmktp.utils.DTOConverter;
import com.mktp.poc.arch.purchasesmktp.utils.NoContentException;
import com.mktp.poc.arch.purchasesmktp.web.CustomerProductDTO;
import com.mktp.poc.arch.purchasesmktp.repo.CustomerProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerProductServiceImpl implements CustomerProductService{

    private final CustomerProductRepository customerProductRepo;

    public CustomerProductServiceImpl(CustomerProductRepository customerProductRepo){
        this.customerProductRepo = customerProductRepo;
    }

    @Override
    public List<CustomerProductDTO> getListOfOrders() throws NoSuchElementException{
        Iterable<CustomerProduct> customerProducts = customerProductRepo.findAll();
        if(!customerProducts.iterator().hasNext())
            throw new NoContentException(GeneralMessagesEnum.NO_PURCHASES_FOUND.toString());

        List<CustomerProductDTO> purchases = new ArrayList<>();
        customerProducts.forEach(customerProductObj -> purchases.add(DTOConverter.getCustomerProductDTO(customerProductObj)));
        return purchases;
    }
}
