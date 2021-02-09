package meet.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import meet.model.domain.entity.Member;
import meet.service.MemberService;

@SessionAttributes({"memberid",})
@Controller(value="logincontroller")
public class LoginController{
	List<Member> loginmemberlist;	//로그인된 멤버들 리스트 관리
	
	@Autowired
	MemberService memberservice;
	@Autowired
	ServletContext servletContext;

	@PostMapping("/logincheck")
	public String loginCheck(@RequestBody String id, @RequestBody String pw,Model model) {		
		Member newmember;
		if((newmember=memberservice.checkMember(id,pw))!=null) {	//회원정보가 있다면
			loginmemberlist.add(newmember);	
			model.addAttribute("memberid",id);	//회원 개인 session에 id 등록			
			servletContext.setAttribute("loginmemberlist", loginmemberlist);	//로그인된 회원 정보들 리스트를 application scope에서 공유
			
			return "redirect:/waitingroom.html";	//수정예정
			
		}else {
			return "forward:/login.html";	//수정예정
		}
	}
}
