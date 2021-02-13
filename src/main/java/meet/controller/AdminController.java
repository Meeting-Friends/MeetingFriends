package meet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/getMemberList")
	public List<Member> getBoardList() {
		return 	memberservice.getMemberList();
	}
	
	@GetMapping("/getLoginMemberList")
	public List<Member> getLoginMemberList(Model model) {
		return adminAllList.getLoginMemberList();
	}
	
	@GetMapping("/getRoomList")
	public List<Room> getRoomList(Model model) {
		return adminAllList.getRoomList();
	}
}
