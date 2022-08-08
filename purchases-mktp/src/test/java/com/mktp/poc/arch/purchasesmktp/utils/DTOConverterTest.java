package com.mktp.poc.arch.purchasesmktp.utils;

import com.mktp.poc.arch.purchasesmktp.model.Customer;
import com.mktp.poc.arch.purchasesmktp.model.CustomerProduct;
import com.mktp.poc.arch.purchasesmktp.model.Product;
import com.mktp.poc.arch.purchasesmktp.model.Supplier;
import com.mktp.poc.arch.purchasesmktp.web.CustomerProductDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DTOConverterTest {

    @Mock
    private CustomerProduct customerProductObj;

    private static Date defaultDate;
    private static Double defaultQuantity;

    @BeforeAll
    static void init() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

        String dateInString = "08-Aug-2022";
        defaultDate = formatter.parse(dateInString);
        defaultQuantity = 15.0;
    }

    @Test
    void getCustomerProductDTOSuccessfull(){

        Customer customerObj = Mockito.mock(Customer.class);
        Product productObj = Mockito.mock(Product.class);
        Supplier supplierObj = Mockito.mock(Supplier.class);

        //Given

        //When
        when(customerProductObj.getIdCustomer()).thenReturn(customerObj);
        when(customerProductObj.getIdProduct()).thenReturn(productObj);
        when(customerProductObj.getIdSupplier()).thenReturn(supplierObj);
        when(customerProductObj.getDate()).thenReturn(defaultDate);
        when(customerProductObj.getQuantity()).thenReturn(defaultQuantity);

        CustomerProductDTO dto = DTOConverter.getCustomerProductDTO(customerProductObj);

        //Then
        assertThat(dto).isNotNull();
        assertThat(dto.getCustomerIdentifier()).isNotNull();
        assertThat(dto.getSupplierIdentifier()).isNotNull();
        assertThat(dto.getProductName()).isNotNull();
        assertThat(dto.getDate()).isNotEmpty();
        assertEquals(defaultDate.toString(),dto.getDate());
        assertEquals(defaultQuantity,dto.getQuantity());
    }

    @Test
    void getCustomerProductDTOEmpty(){
        //Given
        CustomerProduct customerProductNullObj = null;

        //When
        CustomerProductDTO dto = DTOConverter.getCustomerProductDTO(customerProductNullObj);

        //Then
        assertNotNull(dto);
        assertNull(dto.getCustomerIdentifier());
        assertNull(dto.getProductName());
        assertNull(dto.getSupplierIdentifier());
        assertNull(dto.getDate());
        assertNull(dto.getQuantity());
    }
}
