package com.liverpool.online.helpers;

import java.util.HashMap;
import java.util.Set;

/**
 * 
 * Helper Class for Currency (known)
 * 
 * @author philip
 *
 */
public class CurrencyHelper {
	
	/**
	 * Singleton
	 */
	private static CurrencyHelper instance = null;

	/**
	 * Known Currencies
	 */
	private final HashMap<String, Double> currencies = new HashMap<String, Double>();
	
	/**
	 * Contructor
	 */
	private CurrencyHelper() {
		this.currencies.put( "USD", 1.0 );
		this.currencies.put( "EUR", 1.351 );
		this.currencies.put( "CHF", 1.678 );
	}
	
	/**
	 * Get Singleton Instance
	 * 
	 * @return {@link CurrencyHelper}
	 */
	public static CurrencyHelper getInstance() {
		if( instance == null ) {
			instance = new CurrencyHelper();
		}
		
		return instance;
	}
	
	/**
	 * Get the Currencies
	 * 
	 * @return String[]
	 */
	public Set<String> getCurrencies() {
		return this.currencies.keySet();
	}
	
	/**
	 * Get the Translation Factor
	 * 
	 * @param cur
	 * 
	 * @return {@link Double}
	 */
	public Double getTranslationFactor( String cur ) {
		return ( this.isValidCurrency( cur ) == true ) ? this.currencies.get( cur.toUpperCase() ) : 0.0;
	}
	
	/**
	 * Is the Currency known ?
	 * 
	 * @param String cur
	 * 
	 * @return {@link Boolean}
	 */
	public boolean isValidCurrency( String cur ) {
		return (boolean)( this.currencies.containsKey( cur.toUpperCase() ) == true );
	}
	
}
