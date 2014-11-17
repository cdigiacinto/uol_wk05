package com.liverpool.online;

import com.liverpool.online.classes.Money;
import com.liverpool.online.helpers.CurrencyHelper;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MoneyTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MoneyTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MoneyTest.class );
    }

    /**
     * Rigourous Test Money
     */
    public void testMoney()
    {    	
    	// 100 USD != 100 CHF
		Money m100usd = new Money( 100.0, "USD" );
		Money m100chf = new Money( 100.0, "CHF" );
		
		assertNotSame( m100chf, m100usd );
		
		// USD translated to EUR
		Double factorDollar = CurrencyHelper.getInstance().getTranslationFactor( "USD" );
		Double factorEuro = CurrencyHelper.getInstance().getTranslationFactor( "EUR" );
		Money mDollar = new Money( factorDollar, "USD" );
		Money mEuro = new Money( factorEuro, "EUR" );
		
		assertEquals( mEuro.getValue(), ( mDollar.getValue() * factorEuro ) );
		
    }

}
