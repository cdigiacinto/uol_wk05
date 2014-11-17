package com.liverpool.online.classes;

import com.liverpool.online.helpers.CurrencyHelper;

/**
 * 
 * Money Class
 * 
 * @author philip krauss
 *
 */
public class Money {

	private String currency = "USD";
	
	private Double value = 1.0;
	
	private Double usdValue = 1.0;
	
	/**
	 * Constructor
	 * 
	 * @param val
	 * @param cur
	 * 
	 * @throws InvalidCurrencyException 
	 * @throws IsNanValueException 
	 */
	public Money( final Double val, final String cur ) {
		this.value		= val;
		this.currency	= cur.toUpperCase();
		this.usdValue	= ( val * CurrencyHelper.getInstance().getTranslationFactor( cur ) );
	}
	
	@Override
	public String toString() {
		return this.value + " " +this.currency;  
	}
	
	/**
	 * Get the Value
	 * 
	 * @return {@link Double}
	 */
	public Double getValue() {
		return this.value;
	}
}
