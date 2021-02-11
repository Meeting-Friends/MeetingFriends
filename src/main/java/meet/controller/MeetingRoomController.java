package meet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import meet.model.domain.dto.AdminAllList;
import meet.model.domain.dto.Room;

@SessionAttributes({"memberid",})
@Controller(value="MeetingRoomController")
public class MeetingRoomController {
	@Autowired
	AdminAllList adminAllList;
	
	//방삭제 버튼 클릭시 실행
	@GetMapping("/deleteroom")
	public String deleteRoom(@ModelAttribute("room") Room r) {
		
		adminAllList.getRoomList().remove(r);		
		return "redirect:waittingroom.html";
	}
}
