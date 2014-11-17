package com.liverpool.online;

import com.liverpool.online.classes.Account;


import org.junit.Assert;
import org.junit.Test;

public class AccountTest
{

	@Test
	public void BalanceIsPassedToTheConstructor_CorrectlyStoresBalance() {
		double expectedBalance = 300.15;
		Account account = new Account(expectedBalance);
		Assert.assertEquals(expectedBalance, account.getBalance(), Double.MIN_VALUE);
	}

	@Test
	public void NegativeBalancePassedToTheConstructor_CantStoreNegativeDefaultsTheBalanceToZero() {
		Account account = new Account(-123.1);
		Assert.assertEquals(0, account.getBalance(), Double.MIN_VALUE);
	}

	@Test
	public void SettingABalance_CorrectlyStoresBalance() {
		double expectedBalance = 123.1;
		Account account = new Account(0);
		account.setBalance(expectedBalance);
		Assert.assertEquals(expectedBalance, account.getBalance(), Double.MIN_VALUE);
	}

	@Test
	public void SettingANegativeBalance_DoesNotStoreTheBalance() {
		Account account = new Account(0);
		account.setBalance(-123.1);
		Assert.assertEquals(0, account.getBalance(), Double.MIN_VALUE);
	}

	@Test
	public void SettingABalanceThatIsOverTheLimit_DoesNotStoreTheBalance() {
		Account account = new Account(0);
		account.setBalance(20000000000000.0);
		Assert.assertEquals(0, account.getBalance(), Double.MIN_VALUE);
	}

	@Test
	public void DepositingAmount_AddsAmountToBalance() {
		Account account = new Account(123.1);
		account.deposit(100);
		Assert.assertEquals(223.1, account.getBalance(), Double.MIN_VALUE);
	}

	@Test
	public void DepositingAmountThatIsOverTheDepositLimit_RejectsTheDeposit() {
		Account account = new Account(0);
		account.deposit(400000000.0);
		Assert.assertEquals(0, account.getBalance(), Double.MIN_VALUE);
	}

	@Test
	public void DepositingNegativeAmount_RejectsTheDeposit() {
		Account account = new Account(0);
		account.deposit(-123.1);
		Assert.assertEquals(0, account.getBalance(), Double.MIN_VALUE);
	}

	@Test
	public void WithdrawingAmount_SubtractsAmountFromBalance() {
		Account account = new Account(123.1);
		account.withdraw(50.0);
		Assert.assertEquals(73.1, account.getBalance(), Double.MIN_VALUE);
	}

	@Test
	public void WithdrawingNegativeAmount_RejectsTheWithdraw() {
		double balance = 123.1;
		Account account = new Account(balance);
		account.withdraw(-11.1);
		Assert.assertEquals(balance, account.getBalance(), Double.MIN_VALUE);
	}

	@Test
	public void WithdrawingAmountOverTheWithdrawLimit_RejectsTheWithdraw() {
		double balance = 12345.1;
		Account account = new Account(balance);
		account.withdraw(600.0);
		Assert.assertEquals(balance, account.getBalance(), Double.MIN_VALUE);
	}

	@Test
	public void WithdrawingAmountLargerThanTheBalance_RejectsTheWithdraw() {
		double balance = 123.1;
		Account account = new Account(balance);
		account.withdraw(200.0);
		Assert.assertEquals(balance, account.getBalance(), Double.MIN_VALUE);
	}

	@Test
	public void TransferringFunds_SubtractsAmountFromSendingAndDepositsInReceivingAccount() {
		Account sendingAccount = new Account(123.1);
		Account receivingAccount = new Account(0);

		sendingAccount.transferFunds(receivingAccount, 50);
		Assert.assertEquals(73.1, sendingAccount.getBalance(), Double.MIN_VALUE);
		Assert.assertEquals(50, receivingAccount.getBalance(), Double.MIN_VALUE);
	}

	@Test
	public void TransferringFundsWithNegativeAmount_RejectsTheTransfer() {
		Account sendingAccount = new Account(123.1);
		Account receivingAccount = new Account(0);

		sendingAccount.transferFunds(receivingAccount, -11.1);
		Assert.assertEquals(123.1, sendingAccount.getBalance(), Double.MIN_VALUE);
		Assert.assertEquals(0, receivingAccount.getBalance(), Double.MIN_VALUE);
	}

	@Test
	public void TransferringFundsThatAreExceedTheBalance_RejectsTheTransfer() {
		Account sendingAccount = new Account(123.1);
		Account receivingAccount = new Account(0);

		sendingAccount.transferFunds(receivingAccount, 500);
		Assert.assertEquals(123.1, sendingAccount.getBalance(), Double.MIN_VALUE);
		Assert.assertEquals(0, receivingAccount.getBalance(), Double.MIN_VALUE);
	}

	@Test
	public void ComparingTwoAccounts_ReturnsExpectedResults() {
		Account account1 = new Account(0);
		Account account2 = new Account(0);

		Assert.assertTrue(account1.equals(account2));

		account1.setBalance(123.1);
		Assert.assertFalse(account1.equals(account2));
	}

}
