package meet.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import meet.model.domain.dto.AdminAllList;
import meet.model.domain.dto.Room;
import meet.model.domain.entity.Member;

@SessionAttributes({"userinfo","roominfo"})
@RestController(value="WaitingRoomRestController")
public class WaitingRoomRestController {

	@Autowired
	AdminAllList adminAllList;

	//방들 정보 반환
	@GetMapping("/getroomlist")
	public List<Room> getRoomList() {	//반환타입 수정 가능성 확인!!!!
//		List<ModelAndView> list = new ArrayList<ModelAndView>();
//		
//		for(Room r : adminAllList.getRoomList()) {
//			ModelAndView mv = new ModelAndView("getroomlist");
//			mv.addObject("r_id", r.getR_id());
//			mv.addObject("roomhost_id", r.getRoomhost_id());
//			mv.addObject("r_title", r.getTitle());
//			mv.addObject("maxpeople",r.getMaxpeople());
//			mv.addObject("gender",r.getGender());
//			mv.addObject("minage",r.getMinage());
//			mv.addObject("maxage",r.getMaxage());
//			mv.addObject("theme",r.getTheme());
//			mv.addObject("entrancememnum",r.getRoommember().size());
//			list.add(mv);
//		}

		return adminAllList.getRoomList(); 
	}
	
	//로그아웃 버튼 클릭시 실행
	@PostMapping("/logout")
	public String Logout(@RequestBody Member member, SessionStatus status) {
		status.setComplete();	//세션 초기화
		//id를 가진 회원이 로그아웃 요청을 했을 경우 loginmemberlist에서 삭제
		adminAllList.getLoginMemberList()
		.remove(adminAllList.getLoginMemberList().stream().filter(m->m.getId().equals(member.getId())).collect(Collectors.toList()).get(0));

		/* servletcontext를 이용할때 구현방법
		 * 
		List<Member> loginmemberlist = (List<Member>) servletContext.getAttribute("loginmemberlist");
		loginmemberlist.remove(loginmemberlist.stream().filter(m->m.getId().equals(id)).collect(Collectors.toList()).get(0));		
		servletContext.setAttribute("loginmemberlist",loginmemberlist);
		 */
		return "signin";
	}
}
