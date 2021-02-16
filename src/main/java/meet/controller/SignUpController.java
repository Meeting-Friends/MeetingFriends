package meet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import meet.model.domain.entity.Member;
import meet.service.MemberService;

@SessionAttributes({"userinfo","roominfo"})
@RestController(value="SignUpController")
public class SignUpController {
	@Autowired
	MemberService memberservice;

	@PostMapping("/signup")
	public String loginCheck(@RequestBody Member inputmember, Model model) {		

		if(memberservice.checkExistingMember(inputmember.getId())) {
			inputmember.setClassification("일반회원");
			memberservice.insertMember(inputmember);	//DB에 저장
			System.out.println("회원가입성공");
			return "Signin";	
		}else {
			System.out.println("회원가입실패");
			return "Signup";	
		}
	}
}
