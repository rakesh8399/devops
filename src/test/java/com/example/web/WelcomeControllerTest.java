package com.example.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class WelcomeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WelcomeController controller;

	@Test
	void testWelcome() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk())
				.andExpect(model().attribute("Course", containsString("DevOps")));
	}

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
