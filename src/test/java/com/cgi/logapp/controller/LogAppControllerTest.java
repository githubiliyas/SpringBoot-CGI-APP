package com.cgi.logapp.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cgi.starter.CGIAppStarter;

/**
 * The Class LogAppControllerTest.This is a JUnit class for LogAppController
 */
@ContextConfiguration(classes = CGIAppStarter.class)
@RunWith(SpringRunner.class)
@WebMvcTest(LogAppController.class)
public class LogAppControllerTest {

	/** The mock mvc. */
	@Autowired
	MockMvc mockMvc;

	/** The log app controller. */
	@MockBean
	private LogAppController logAppController;

	/**
	 * Test get logs by type.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGetLogsByType() throws Exception {

		// Calling the api to check for the view returned.
		this.mockMvc.perform(MockMvcRequestBuilders.get("/logtype?loglevel=WARN")).andExpect(status().isOk())
				.andExpect(view().name((("logtype"))));

	}

}
