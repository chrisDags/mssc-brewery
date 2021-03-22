package com.dags.msscbrewery.web.services;

import com.dags.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;


public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);
}
