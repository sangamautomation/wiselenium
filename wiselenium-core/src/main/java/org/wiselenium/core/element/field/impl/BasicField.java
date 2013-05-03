package org.wiselenium.core.element.field.impl;

import static org.wiselenium.core.WiseUnwrapper.unwrapWebElement;

import org.wiselenium.core.element.field.Field;

/**
 * Basic implementation of a common Field. <br/>
 * Should be extended to reflect your own field methods.
 * 
 * @author Andre Ricardo Schaffer
 * @param <T> The field type.
 * @since 0.0.1
 */
@SuppressWarnings("unchecked")
public class BasicField<T extends Field<T>> implements Field<T> {
	
	@Override
	public T and() {
		return (T) this;
	}
	
	@Override
	public T click() {
		unwrapWebElement(this).click();
		return (T) this;
	}
	
	@Override
	public T doubleClick() {
		// TODO will need a webdriver reference
		return (T) this;
	}
	
	@Override
	public String getAttribute(String name) {
		return unwrapWebElement(this).getAttribute(name);
	}
	
	@Override
	public String getCssValue(String propertyName) {
		return unwrapWebElement(this).getCssValue(propertyName);
	}
	
	@Override
	public boolean isDisplayed() {
		return unwrapWebElement(this).isDisplayed();
	}
	
}
