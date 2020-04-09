package com.greydawn.hotelms.service.impl;


import com.greydawn.hotelms.dao.IAccountdao;
import com.greydawn.hotelms.domain.Account;
import com.greydawn.hotelms.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    IAccountdao accountdao;
    @Override
    public List<Account> findAll() {
        System.out.println("Service业务层：查询所有账户...");
        return accountdao.findAll();
    }

    @Override
    public Account findById(Integer id){
        return accountdao.findById(id);
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("Service业务层：保存帐户...");
        System.out.println(account);
        accountdao.saveAccount(account);
    }
}

