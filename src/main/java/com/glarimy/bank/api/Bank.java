package com.glarimy.bank.api;

import com.glarimy.bank.domain.Account;
import com.glarimy.bank.exceptions.AccountNotFoundException;
import com.glarimy.bank.exceptions.BankException;
import com.glarimy.bank.exceptions.InvalidAccountException;

public interface Bank {
	public Account open(Account account) throws InvalidAccountException, BankException;

	public Account getAccount(int number) throws AccountNotFoundException, BankException;
}
