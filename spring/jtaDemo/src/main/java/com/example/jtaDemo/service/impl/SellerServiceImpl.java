package com.example.jtaDemo.service.impl;

import com.example.jtaDemo.dao.entity.Seller;
import com.example.jtaDemo.dao.mapper.mysqlMapper.SellerMapper;
import com.example.jtaDemo.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerMapper sellerMapper;

    @Override
    public void sell(Integer i) throws Exception {

        Seller seller = sellerMapper.selectByPrimaryKey("1");
        if(seller.getHealthPotion()-i<0)
            throw new Exception("potion is not enough.");
        seller.setGold(seller.getGold()+i*50);
        seller.setHealthPotion(seller.getHealthPotion()-i);
        sellerMapper.updateByPrimaryKey(seller);
    }
}
