package meet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import meet.model.domain.dto.AdminAllList;
import meet.model.domain.dto.Room;
import meet.model.domain.entity.Member;

@SessionAttributes({"userinfo","roominfo"})
@Controller(value="MeetingRoomController")
public class MeetingRoomController {
	@Autowired
	AdminAllList adminAllList;

	//방나가기 버튼 클릭시 실행
	@GetMapping("/exitroom")		//http://192.168.35.115:80/exitroom/room/${roomid}/user/${userEmail}
	public String exitRoom(@ModelAttribute("room") Room r, @ModelAttribute("member")Member m, Model model) {
		Room temproom=null;
		for(Room r2 : adminAllList.getRoomList()) {	//요청받은 r의 방id와 같은 방 객체 찾기
			if(r2.getRId().equals(r.getRId())) {
				temproom=r2;
				break;
			}
		}

		if(temproom.getRoommember().size()==1) {	//방에 남은사람이 1명일때
			adminAllList.getRoomList().remove(temproom);
		}

		model.addAttribute("roomid", null);	//본인 세션의 roomid null로 수정
		return "wattingroom";
	}

	//webrtc 방수정 버튼 클릭시 실행
	@GetMapping("/changeroominfo")
	public String changeRoomInfo(@ModelAttribute("room") Room r, Model model) {
		Room temproom=null;
		for(Room r2:adminAllList.getRoomList()) {	//요청받은 r의 방id와 같은 방 객체 찾기
			if(r2.getRId().equals(r.getRId())) {
				temproom=r2;
				break;
			}
		}
		temproom.setTitle(r.getTitle());
		temproom.setMaxage(r.getMaxage());
		temproom.setMinage(r.getMinage());
		temproom.setTheme(r.getTheme());
		temproom.setMaxpeople(r.getMaxage());
		
		model.addAttribute("roominfo",temproom);
		
		return "redirect:localhost:3333/"+r.getRId();
	}
}
