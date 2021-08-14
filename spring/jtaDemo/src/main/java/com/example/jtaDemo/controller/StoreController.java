package com.example.jtaDemo.controller;

import com.example.jtaDemo.service.CustomerService;
import com.example.jtaDemo.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {
    @Autowired
    CustomerService customerService;

    @Autowired
    SellerService sellerService;

//    @Transactional
    @GetMapping("/deal")
    public String deal(@RequestParam Integer i ) throws Exception {
        customerService.consume(i);
//        int a = 1/0;
        sellerService.sell(i);
        return "交易成功";
    }
}
