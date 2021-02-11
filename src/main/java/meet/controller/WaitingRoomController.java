package meet.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import meet.model.domain.dto.AdminAllList;
import meet.model.domain.dto.Room;
import meet.model.domain.entity.Member;
import meet.service.MemberService;

@SessionAttributes({"memberid","roomid"})
@Controller(value="WaitingRoomController")
public class WaitingRoomController {
	@Autowired
	AdminAllList adminAllList;
	@Autowired
	MemberService memberservice;
	//	@Autowired
	//	ServletContext servletContext;

	//로그아웃 버튼 클릭시 실행
	@GetMapping("/logout")
	public String Logout(@RequestParam String id,SessionStatus status) {

		status.setComplete();	//세션 초기화
		//id를 가진 회원이 로그아웃 요청을 했을 경우 loginmemberlist에서 삭제
		adminAllList.getLoginMemberList()
		.remove(adminAllList.getLoginMemberList().stream().filter(m->m.getId().equals(id)).collect(Collectors.toList()).get(0));

		/* servletcontext를 이용할때 구현방법
		 * 
		List<Member> loginmemberlist = (List<Member>) servletContext.getAttribute("loginmemberlist");
		loginmemberlist.remove(loginmemberlist.stream().filter(m->m.getId().equals(id)).collect(Collectors.toList()).get(0));		
		servletContext.setAttribute("loginmemberlist",loginmemberlist);
		 */

		return "redirect:main.html";
	}

	//방정보 입력후 방만들기 버튼 클릭시 실행(방장O)
	@PostMapping("/createroom")
	public String createRoom(@RequestBody Room r,Model model) {
		model.addAttribute("roomid",r.getR_id());
		r.setRoomhost_id(model.getAttribute("memberid").toString());
		adminAllList.getRoomList().add(r);
		return "forward:meetingroom.html";	//room id와 함께 전송하도록 수정!!!!
	}

	//방 입장 버튼 클릭시 실행(방장X)
	@GetMapping("/entranceroom")
	public String entranceRoom(@ModelAttribute("room") Room room, @ModelAttribute("member") Member member,Model model) {
		for(Room r : adminAllList.getRoomList()){
			if(room.getR_id().equals(r.getR_id())) {
				model.addAttribute("roomid",room.getR_id());
				r.getRoommember().add(member);	//입장하려는 방을 찾아서 member리스트에 추가
				return "forward:meetingroom.html";	//room id와 함께 전송하도록 수정!!!!
			}
		}
		return "forward:waitingroom.html";	//찾고자 하는 방이 리스트에 없을 경우 대기실로 다시 돌아감.
	}

}
