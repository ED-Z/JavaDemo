package com.example.jtaDemo.service.impl;

import com.example.jtaDemo.dao.entity.Customer;
import com.example.jtaDemo.dao.mapper.pgsqlMapper.CustomerMapper;
import com.example.jtaDemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public void consume(Integer i) throws Exception {
        Customer customer = customerMapper.selectByPrimaryKey("1");
        if(customer.getGold()-i*50<0)
            throw new Exception("gold is not enough.");
        customer.setGold(customer.getGold()-i*50);
        customer.setHealthPotion(customer.getHealthPotion()+i);
        customerMapper.updateByPrimaryKey(customer);
    }
}
