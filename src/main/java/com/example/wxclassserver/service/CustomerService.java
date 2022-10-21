/**
 * @Author Ls
 * @Date 2022/10/21 11:10
 * @Description CustomerService
 * @Version 1.0
 */
package com.example.wxclassserver.service;

import com.example.wxclassserver.mapper.CustomerMapper;
import com.example.wxclassserver.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    public List<Customer> list(){
        return customerMapper.list();
    }

    public void add(Customer customer) {

        try{
            customerMapper.add(customer);

        }catch (Exception e){
            System.out.println(customer.getNickname()+"已经存在,不要重复保存");
            e.printStackTrace();
        }

    }
}
