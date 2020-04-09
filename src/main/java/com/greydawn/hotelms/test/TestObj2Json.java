package com.greydawn.hotelms.test;

import com.alibaba.fastjson.JSON;
import com.greydawn.hotelms.domain.Account;
import org.junit.Test;

public class TestObj2Json {
    @Test
    public void Test(){
        Account account =new Account();
        account.setId(666);
        account.setName("sixsix");
        account.setMoney(8800.0);
        String o2j=JSON.toJSONString(account);
        System.out.println(o2j);
    }

}
