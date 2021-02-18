package meet.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import meet.model.domain.dto.AdminAllList;
import meet.model.domain.dto.Room;
import meet.model.domain.entity.Member;
import meet.service.MemberService;

@SessionAttributes({"userinfo","roominfo"})
@RestController(value="MeetingRoomController")
public class MeetingRoomController {
	@Autowired
	AdminAllList adminAllList;
	@Autowired
	MemberService memberservice;
	
	//방나가기 버튼 클릭시 실행
	@GetMapping("/exitroom/room/{roomid}/user/{userEmail}")		//http://192.168.35.115:80/exitroom/room/${roomid}/user/${userEmail}
	public String exitRoom(@PathVariable String roomid,@PathVariable String userEmail, Model model) throws JsonMappingException, JsonProcessingException {
				
		Room temproom=null;
		for(Room r2 : adminAllList.getRoomList()) {	//요청받은 r의 방id와 같은 방 객체 찾기
			if(r2.getRId().equals(roomid)) {
				temproom=r2;
				break;
			}
		}

		for(Member m:temproom.getRoommember()) {	//방의 멤버리스트에서 나가려는 회원을 제거
			if(m.getId().equals(userEmail)) {
				temproom.getRoommember().remove(m);
				break;
			}
		}
		
		if(temproom.getRoommember().size()==1) {	//방에 남은사람이 1명일때
			adminAllList.getRoomList().remove(temproom);	//방 리스트에서 방 제거
		}
		
		
		model.addAttribute("roomid", null);	//본인 세션의 roomid null로 수정
		return "waittingroom";
	}

	//webrtc 방수정 버튼 클릭시 실행
	@PostMapping("/changeroominfo")
	public String changeRoomInfo(@RequestBody JSONObject obj, Model model) throws JsonMappingException, JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		Room room = mapper.readValue(obj.get("room").toString(), Room.class);
		Member member = mapper.readValue(obj.get("member").toString(), Member.class);
		
		Room temproom=null;
		for(Room r2:adminAllList.getRoomList()) {	//요청받은 r의 방id와 같은 방 객체 찾기
			if(r2.getRId().equals(room.getRId())) {
				temproom=r2;
				break;
			}
		}
		temproom.setTitle(room.getTitle());
		temproom.setMaxage(room.getMaxage());
		temproom.setMinage(room.getMinage());
		temproom.setTheme(room.getTheme());
		temproom.setMaxpeople(room.getMaxage());
		
		model.addAttribute("roominfo",temproom);
		
		return "방정보 수정완료!";
	}
	
	@GetMapping("/room/{roomid}")	//get(`http://localhost:80/room/${ROOM_ID}`)
	public String getRoomInfo(@PathVariable String roomid, Model model) throws JsonMappingException, JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		Room temproom=null;
		
		for(Room r2:adminAllList.getRoomList()) {	//요청받은 r의 방id와 같은 방 객체 찾기
			if(r2.getRId().equals(roomid)) {
				temproom=r2;
				break;
			}
		}		
		
		return mapper.writeValueAsString(temproom);
	}
	
	@GetMapping("/user/{userEmail}")	//.get(`http://localhost:80/user/${vm.$data.userEmail}`)
	public String getUserInfo(@PathVariable String userEmail, Model model) throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();		
		Member m = memberservice.getMemberInfo(userEmail);
		
		return mapper.writeValueAsString(m);
	}
}
