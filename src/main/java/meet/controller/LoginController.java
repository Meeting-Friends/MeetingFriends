package meet.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import meet.model.domain.dto.AdminAllList;
import meet.model.domain.entity.Member;
import meet.service.MemberService;

@SessionAttributes({"userinfo","roominfo"})
@RestController(value="LoginController")
public class LoginController{
	@Autowired
	AdminAllList adminAllList;
	@Autowired
	MemberService memberservice;
//	@Autowired
//	ServletContext servletContext;

	@PostMapping("/signin")
	public JSONObject loginCheck(@RequestBody Member member, Model model) {		
		Member newmember = memberservice.checkMember(member.getId(), member.getPw());
		JSONObject jsonObj = new JSONObject();
		
		for(Member m : adminAllList.getLoginMemberList()) {	
			if(m.getId().equals(newmember.getId())) {	//이미 로그인된 회원이라면 대기실화면으로 이동 불가
				jsonObj.put("desturl","signin");
				return jsonObj;
			}
		}
		
		if(newmember!=null) {	//회원정보가 있다면	
			if(newmember.getId().equals("admin")) {	//관리자일때				
				newmember.setPhonenumber(null);
				newmember.setName(null);
				newmember.setPw(null);
				newmember.setContent(null);
				newmember.setComment(null);
				jsonObj.put("memberinfo", newmember);
				jsonObj.put("desturl", "admin");
				
			}else {	//일반회원일때
				newmember.setPhonenumber(null);
				newmember.setName(null);
				newmember.setPw(null);
				newmember.setContent(null);
				newmember.setComment(null);
				adminAllList.getLoginMemberList().add(newmember);					
				model.addAttribute("userinfo",model);	//회원 개인 session에 id 등록		
			//	servletContext.setAttribute("loginmemberlist", adminAllList.getLoginmemberlist());	//로그인된 회원 정보들 리스트를 application scope에서 공유

				jsonObj.put("memberinfo", newmember);
				jsonObj.put("desturl", "waittingroom");
			}			
	
		}else {	//DB에 회원정보가 없을때
			jsonObj.put("desturl", "signin");
		}

		return jsonObj;
	}
}
