package meet;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import meet.controller.SignUpController;

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
	//	mock.perform(get("/")).andExpect(status().isOk()).andDo(print());
	//	mock.perform(get("/param").param("id", "data")).andDo(print());
		mock.perform(post("/signup").param("id", "kim").param("pw", "123").param("name","junhyeong").param("nickname","lakjdsflfjads")
				.param("phonenumber","123123123").param("birth","1022").param("gender","man").param("classification","master")).andDo(print());
		
			
		
	//	mock.perform(get("/validate")).andExpect(status().isOk()).andExpect(jsonPath("$.name").value("playdataman")).andDo(print());
	//	mock.perform(get("/validate")).andExpect(status().isOk()).andExpect(jsonPath("$.name").value("test")).andDo(print());
	}
}
