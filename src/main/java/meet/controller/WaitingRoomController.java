package meet.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import meet.model.domain.dto.AdminAllList;
import meet.model.domain.dto.Room;
import meet.model.domain.entity.Member;
import meet.service.MemberService;

@SessionAttributes({"userinfo","roominfo"})
@RestController(value="WaitingRoomController")
public class WaitingRoomController {
	@Autowired
	AdminAllList adminAllList;
	@Autowired
	MemberService memberservice;
	//@Autowired
	//ServletContext servletContext;


	//방정보 입력후 방만들기 버튼 클릭시 실행(방장O)
	@PostMapping("/createroom")
	public String createRoom(@RequestBody JSONObject obj, Model model) throws JsonMappingException, JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		Room room = mapper.readValue(obj.get("room").toString(), Room.class);
		Member member = mapper.readValue(obj.get("member").toString(), Member.class);
		
		room.setRId(Integer.toString((int)(Math.random() * 10000)));	//방id 랜덤으로 생성
		room.getRoommember().add(member);
		model.addAttribute("roominfo",room);	
		adminAllList.getRoomList().add(room);
		
		return "https://192.168.25.51:3333/room/"+room.getRId();
	}
	
	@PostMapping("/entranceroom")
	public String entranceRoom(@RequestBody JSONObject obj, Model model) throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		Room room = mapper.readValue(obj.get("room").toString(), Room.class);
		Member member = mapper.readValue(obj.get("member").toString(), Member.class);
		
		for(Room r : adminAllList.getRoomList()){
			if(room.getRId().equals(r.getRId())) {
				r.getRoommember().add(member);	//입장하려는 방을 찾아서 member리스트에 추가
				model.addAttribute("roominfo",room);

				return "https://192.168.25.51:3333/room/"+room.getRId();	//room id와 함께 전송하도록 수정!!!!
			}
		}
		return "waittingroom";	
	}
	
	//방들 정보 반환
		@GetMapping("/getroomlist")
		public List<Room> getRoomList() {	//반환타입 수정 가능성 확인!!!!
//			List<ModelAndView> list = new ArrayList<ModelAndView>();
//			
//			for(Room r : adminAllList.getRoomList()) {
//				ModelAndView mv = new ModelAndView("getroomlist");
//				mv.addObject("r_id", r.getR_id());
//				mv.addObject("roomhost_id", r.getRoomhost_id());
//				mv.addObject("r_title", r.getTitle());
//				mv.addObject("maxpeople",r.getMaxpeople());
//				mv.addObject("gender",r.getGender());
//				mv.addObject("minage",r.getMinage());
//				mv.addObject("maxage",r.getMaxage());
//				mv.addObject("theme",r.getTheme());
//				mv.addObject("entrancememnum",r.getRoommember().size());
//				list.add(mv);
//			}
			System.out.println(adminAllList.getRoomList());
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
