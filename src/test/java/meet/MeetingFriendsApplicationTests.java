package meet;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import meet.controller.SignUpController;
import meet.model.domain.entity.Member;

@SpringBootTest
class MeetingFriendsApplicationTests {
	@Autowired
	private SignUpController controller;

	private MockMvc mock;

	@BeforeEach
	public void init() {
		mock = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	void controllerTest() throws Exception {
		
		String content = ObjectMapper..writeValueAsString(new Member("kim", "123","junhyeong","lakjdsflfjads","123123123","1022","man","master"));

		mock.perform(post("/signup")
	        .content(content)
	        .contentType(MediaType.APPLICATION_JSON)
	        .accept(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk())
	        .andDo(print());
	  }
	//	mock.perform(get("/")).andExpect(status().isOk()).andDo(print());
	//	mock.perform(get("/param").param("id", "data")).andDo(print());
	
			
		
	//	mock.perform(get("/validate")).andExpect(status().isOk()).andExpect(jsonPath("$.name").value("playdataman")).andDo(print());
	//	mock.perform(get("/validate")).andExpect(status().isOk()).andExpect(jsonPath("$.name").value("test")).andDo(print());
	}
}
