package meet.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import meet.model.domain.dto.AdminAllList;
import meet.model.domain.entity.Member;
import meet.service.MemberService;

@SessionAttributes({"memberid",})
@Controller(value="LoginController")
public class LoginController{
	@Autowired
	AdminAllList adminAllList;
	@Autowired
	MemberService memberservice;
//	@Autowired
//	ServletContext servletContext;

	@PostMapping("/signin")
	public String loginCheck(@RequestBody Member member,Model model) {				
		Member newmember = memberservice.checkMember(member.getId(),member.getPw());

		if(newmember!=null) {	//회원정보가 있다면	
			if(newmember.getId().equals("admin")) {	//관리자일때
				return "redirect:/adminpage.html";	//수정예정
			}else {	//일반회원일때
				adminAllList.getLoginMemberList().add(newmember);	
				model.addAttribute("memberid",newmember.getId());	//회원 개인 session에 id 등록			
			//	servletContext.setAttribute("loginmemberlist", adminAllList.getLoginmemberlist());	//로그인된 회원 정보들 리스트를 application scope에서 공유
				System.out.println("로그인성공!!!");
				System.out.println(adminAllList.getLoginMemberList());
				return "redirect:/waitingroom.vue";	//수정예정
			}			
		}else {	
			System.out.println("로그인 실패!!");		
			return "forward:/login.html";	//수정예정
		}
	}
}
