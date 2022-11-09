package com.onboarding.redirectUrl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.onboarding.redirectUrl.repository.UrlRepository;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.onboarding.redirectUrl.controller.UrlController;
import com.onboarding.redirectUrl.model.Url;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@AutoConfigureMockMvc
@EnableWebMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = {UrlController.class, Url.class})
class RedirectUrlApplicationTests {

	@MockBean
	UrlRepository urlRepository;

	@Autowired
    private MockMvc mockMvc;

	@Test
	public void createTest() throws Exception{
		Url site = new Url(); //id 4
		site.setId(4L);
		site.setName("LinkedIN");
		site.setLink("http://www.linkedin.com/");

		JSONObject response = new JSONObject();
		response.put("id", site.getId());
		response.put("name", site.getName());
		response.put("link", site.getLink());

		mockMvc.perform(post("http://localhost:8080/create")
						.contentType(MediaType.APPLICATION_JSON)
						.content(response.toString())
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name").value("LinkedIN"))
				.andExpect(jsonPath("$.link").value("http://www.linkedin.com/"));
	}


	@Test
	public void acessTest() throws Exception {
		Url site = new Url(); //id 6
		site.setId(6L);
		site.setName("YouTube");
		site.setLink("https://www.youtube.com/");

		Mockito.when(urlRepository.save(site)).thenReturn(site);
		mockMvc.perform(get("http://localhost:8080/acess/6"))
				.andExpect(status().isOk());
	}

}
