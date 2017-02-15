package hello;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void homePage() throws Exception{
		mockMvc.perform(get("/index.html"))
				.andExpect(content().string(containsString("Get your greeting")));
	}
	
	@Test
	public void greeting() throws Exception{
		mockMvc.perform(get("/greeting"))
				.andExpect(content().string(containsString("Hello, World!")));
			
	}
	
	@Test
	public void greetingWithUser() throws Exception{
		mockMvc.perform(get("/greeting").param("name", "Hyunree"))
				.andExpect(content().string(containsString("Hello, Hyunree!")));
	}
	

}
