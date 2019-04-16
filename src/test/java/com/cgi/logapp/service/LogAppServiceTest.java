package com.cgi.logapp.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cgi.starter.CGIAppStarter;

/**
 * The Class LogAppServiceTest. This is a JUnit class for the RecipeService.
 */
@SpringBootTest(classes = { CGIAppStarter.class })
@RunWith(SpringRunner.class)
public class LogAppServiceTest {

	/** The recipe service. */
	@Autowired
	private LogAppService logService;

	/**
	 * Test get logs by type. In this case as we are 
	 * providing a valid log level, so the log list
	 * is getting populated.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	public void testGetLogsByTypeCaseOne() throws IOException {
		
		// Asserting the returned values.
		Assert.assertNotNull(logService.getLogsByType("DEBUG"));
		Assert.assertFalse(logService.getLogsByType("DEBUG").isEmpty());
	}
	
	/**
	 * Test get logs by type. In this case as we are 
	 * providing an invalid log level, so the log list
	 * is not getting populated.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	public void testGetLogsByTypeCaseTwo() throws IOException {
		
		// Asserting the returned values.
		Assert.assertNull(logService.getLogsByType("BUG"));
	}
	
	/**
	 * Test get recipes as string.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws IllegalAccessException the illegal access exception
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws InvocationTargetException the invocation target exception
	 * @throws NoSuchMethodException the no such method exception
	 * @throws SecurityException the security exception
	 */
	@Test
	public void testGetRecipeAsString() throws IOException, IllegalAccessException, 
		IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		// Using reflection to access the private method.
		Method privateMethod = LogAppService.class.getDeclaredMethod("getLogsAsString");
		privateMethod.setAccessible(Boolean.TRUE);
		
		// Asserting the returned values.
		Assert.assertNotNull(privateMethod.invoke(logService, null));
	}

}
