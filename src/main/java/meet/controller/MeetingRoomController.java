package meet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import meet.model.domain.dto.AdminAllList;
import meet.model.domain.dto.Room;
import meet.model.domain.entity.Member;

@SessionAttributes({"memberid","roomid"})
@Controller(value="MeetingRoomController")
public class MeetingRoomController {
	@Autowired
	AdminAllList adminAllList;
	
	//방나가기 버튼 클릭시 실행
	@GetMapping("/exitroom")
	public String exitRoom(@ModelAttribute("room") Room r,@ModelAttribute("member")Member m, Model model) {
		Room temproom=null;
		for(Room r2:adminAllList.getRoomList()) {	//요청받은 r의 방id와 같은 방 객체 찾기
			if(r2.getR_id().equals(r.getR_id())) {
				temproom=r2;
				break;
			}
		}
		
		if(temproom.getRoommember().size()==1) {	//방에 남은사람이 1명일때
			adminAllList.getRoomList().remove(temproom);
		}else {	//두명이상일때
			if(temproom.getRoomhost_id().equals(model.getAttribute("memberid"))){	//방장이 나가기 버튼을 눌렀을 경우
				temproom.setRoomhost_id(temproom.getRoommember().get(0).getId());	//실제 리스트의 방장 정보도 바뀌는 지 확인필요
				System.out.println(temproom.getRoomhost_id());
				System.out.println(adminAllList.getRoomList());
			}
		}

		model.addAttribute("roomid",null);	//본인 세션의 roomid null로 수정
		return "redirect:waittingroom.html";
	}
	
	//방수정 버튼 클릭시 실행
	@GetMapping("/changeroominfo")
	public void changeRoomInfo(@ModelAttribute("room") Room r) {
		Room temproom=null;
		for(Room r2:adminAllList.getRoomList()) {	//요청받은 r의 방id와 같은 방 객체 찾기
			if(r2.getR_id().equals(r.getR_id())) {
				temproom=r2;
				break;
			}
		}
		temproom.setTitle(r.getTitle());
		temproom.setMaxage(r.getMaxage());
		temproom.setMinage(r.getMinage());
		temproom.setTheme(r.getTheme());
		temproom.setMaxpeople(r.getMaxage());
	}
}
