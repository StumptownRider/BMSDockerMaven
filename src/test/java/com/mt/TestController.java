package com.mt;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.junit.Assert.*;

import com.mt.HelloWorldController;

public class TestController {

	@InjectMocks
	private HelloWorldController helloWorldController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();
	}

	@Test
	public void testCreateSignupFormInvalidUser() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk());
	}
	
	@Test
    	public void testAppCalc() {
        try {
            int res=HelloWorldController.calcProduct(5,10);
            int expected=5*10;
            assertEquals(expected, res);
        } catch (AssertionError e1) {
            fail("Not 50");
        }
    }
}
