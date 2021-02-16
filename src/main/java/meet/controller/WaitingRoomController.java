package meet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import meet.model.domain.dto.AdminAllList;
import meet.model.domain.dto.Room;
import meet.model.domain.entity.Member;
import meet.service.MemberService;

@SessionAttributes({"userinfo","roominfo"})
@Controller(value="WaitingRoomController")
public class WaitingRoomController {
	@Autowired
	AdminAllList adminAllList;
	@Autowired
	MemberService memberservice;
	//@Autowired
	//ServletContext servletContext;

	//방정보 입력후 방만들기 버튼 클릭시 실행(방장O)
	@PostMapping("/createroom")
	public String createRoom(@RequestBody Room room, @ModelAttribute("member") Member member, Model model) {

		room.setRId(Integer.toString((int)(Math.random() * 10000)));	//방id 랜덤으로 생성
		room.getRoommember().add(member);
		model.addAttribute("roominfo",room);	
		adminAllList.getRoomList().add(room);

		return "redirect:localhost:3333/"+room.getRId();	
	}

	//방 입장 버튼 클릭시 실행(방장X)
	@GetMapping("/entranceroom")
	public String entranceRoom(@ModelAttribute("room") Room room, @ModelAttribute("member") Member member, Model model) {

		for(Room r : adminAllList.getRoomList()){
			if(room.getRId().equals(r.getRId())) {
				r.getRoommember().add(member);	//입장하려는 방을 찾아서 member리스트에 추가
				model.addAttribute("roominfo",room);
				
				return "redirect:localhost:3333/"+room.getRId();	//room id와 함께 전송하도록 수정!!!!
			}
		}
		return "forward:/frontend/src/views/WaittingRoom.vue";	
	}
}
