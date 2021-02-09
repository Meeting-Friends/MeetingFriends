package meet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import meet.model.domain.entity.Member;
import meet.service.MemberService;

@Controller(value="signupcontroller")
public class SignUpController {
	@Autowired
	MemberService memberservice;

	@PostMapping("/signup")
	public String loginCheck(@RequestBody Member inputmember,Model model) {		
		if(memberservice.checkExistingMember(inputmember.getId())) {
			memberservice.insertMember(inputmember);	//DB에 저장
			return "redirect:signin.html";	//회원가입 성공시, 로그인 페이지로 이동
		}else {
			return "foward:signup.html";	//회원가입가입 실패시, 이미 가입된 회원이거나 정보가 누락되었을 경우
		}
	}
}
