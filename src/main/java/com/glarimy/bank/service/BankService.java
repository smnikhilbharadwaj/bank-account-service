package com.glarimy.bank.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.glarimy.bank.api.Bank;
import com.glarimy.bank.data.AccountRepository;
import com.glarimy.bank.domain.Account;
import com.glarimy.bank.exceptions.AccountNotFoundException;
import com.glarimy.bank.exceptions.BankException;
import com.glarimy.bank.exceptions.InvalidAccountException;

@Service
@EnableTransactionManagement
public class BankService implements Bank {
	@Autowired
	private AccountRepository repo;

	@Override
	@Transactional
	public Account open(Account account) throws InvalidAccountException, BankException {
		repo.save(account);
		return account;
	}

	@Override
	public Account getAccount(int number) throws AccountNotFoundException, BankException {
		return repo.findOne(number);
	}

}
