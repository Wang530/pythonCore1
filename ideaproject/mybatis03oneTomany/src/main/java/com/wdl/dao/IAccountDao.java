package com.wdl.dao;

import com.wdl.domain.Account;
import com.wdl.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
    List<Account> findAll();
    List<AccountUser> findAllAccount();
}
