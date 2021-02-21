package meet.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import meet.model.domain.dto.AdminAllList;
import meet.model.domain.dto.Room;
import meet.model.domain.entity.Member;
import meet.service.MemberService;

@RestController(value="AdminController")
public class AdminController {
	@Autowired 
	AdminAllList adminAllList;
	@Autowired
	MemberService memberservice;
	
	//전체 회원정보 반환
	@GetMapping("/getMemberList")
	public String getBoardList() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();		
		return mapper.writeValueAsString(memberservice.getMemberList());
	}
	
	//로그인된 전체 회원정보 반환
	@GetMapping("/getLoginMemberList")
	public String getLoginMemberList(Model model) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();		
		return mapper.writeValueAsString(adminAllList.getLoginMemberList());
	}
	
	@GetMapping("/getRoomList")
	public String getRoomList(Model model) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();		
		return mapper.writeValueAsString(adminAllList.getRoomList());
	}
}
