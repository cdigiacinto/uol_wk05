package com.liverpool.online;

import com.liverpool.online.classes.Money;
import com.liverpool.online.helpers.CurrencyHelper;

/**
 * 
 * Simple App Class (STUB)
 * 
 * @author Philip Krauss
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Group 4 - Week05 - Assignment" );
        
		Money m = new Money( 100.0, "USD" );
		System.out.println( ">> " + m );
		
		Double factorDollar = CurrencyHelper.getInstance().getTranslationFactor( "USD" );
		Double factorEuro = CurrencyHelper.getInstance().getTranslationFactor( "EUR" );
		Money mDollar = new Money( factorDollar, "USD" );
		Money mEuro = new Money( factorEuro, "EUR" );
		
		System.out.println( ">> " + ( mDollar.getValue() * factorEuro ) );
		System.out.println( ">> " + mEuro );
    }
}
