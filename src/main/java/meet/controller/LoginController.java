package meet.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import meet.domain.entity.Member;

@Controller(value="logincontroller")
public class LoginController {
	List<Member> loginmemberlist;	//로그인된 멤버들 리스트 관리
		
}
