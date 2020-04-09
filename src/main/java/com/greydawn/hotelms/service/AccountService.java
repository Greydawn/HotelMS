package com.greydawn.hotelms.service;

import com.greydawn.hotelms.domain.Account;
import java.util.List;

public interface AccountService {
    /**
     * 查询所有账户
     * @return
     */
    public List<Account> findAll();

    /**
     * 根据id查询账户
     * @param id
     * @return
     */
    public Account findById(Integer id);

    /**
     * 保存帐户信息
     * @param account
     */
    public void saveAccount(Account account);
}

