package com.dags.msscbrewery.web.mappers;

import com.dags.msscbrewery.domain.Customer;
import com.dags.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDto customerDto);
    CustomerDto customerToCustomerDto(Customer customer);
}
