package com.mktp.poc.arch.purchasesmktp.repo;

import com.mktp.poc.arch.purchasesmktp.model.CustomerProduct;
import org.springframework.data.repository.CrudRepository;

public interface CustomerProductRepository extends CrudRepository<CustomerProduct, Integer> {
}
