package com.liverpool.online;

import com.liverpool.online.classes.Account;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AccountTest extends TestCase
{

	public AccountTest( String testName )
	{
		super(testName);
	}

	public static Test Suite()
	{
		return TestSuite(AccountTest.class);
	}

	public void testAccountInstantiation()
	{
		double negativeBalance	= -10.0;


	}

}
