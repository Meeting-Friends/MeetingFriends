package meet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import meet.model.domain.dto.AdminAllList;
import meet.model.domain.dto.Room;

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


}
