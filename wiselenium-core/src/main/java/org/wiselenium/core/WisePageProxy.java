package org.wiselenium.core;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.WrapsDriver;

/**
 * The wiselenium proxy for pages.
 * 
 * @author Andre Ricardo Schaffer
 * @since 0.0.1
 */
public class WisePageProxy implements MethodInterceptor {
	
	private static final String GET_WRAPPED_DRIVER_METHOD_NAME = "getWrappedDriver";
	private final WebDriver driver;
	
	
	private WisePageProxy(WebDriver driver) {
		this.driver = driver;
	}
	
	static WisePageProxy getInstance(WebDriver driver) {
		return new WisePageProxy(driver);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
		throws Throwable {
		
		if (GET_WRAPPED_DRIVER_METHOD_NAME.equals(method.getName())) {
			if (!(obj instanceof WrapsDriver)) throw new WebDriverNotWrappedException(obj);
			return this.driver;
		}
		
		return proxy.invokeSuper(obj, args);
	}
	
}