package meet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import meet.model.domain.dto.AdminAllList;
import meet.model.domain.dto.Room;

@RestController(value="WaitingRoomRestController")
public class WaitingRoomRestController {

	@Autowired
	AdminAllList adminAllList;

	//방들 정보 반환
	@GetMapping("/getroomlist")
	public List<ModelAndView> getRoomList() {	//반환타입 수정 가능성 확인!!!!
		List<ModelAndView> list = new ArrayList<ModelAndView>();
		
		for(Room r : adminAllList.getRoomList()) {
			ModelAndView mv = new ModelAndView("getroomlist");
			mv.addObject("r_id", r.getR_id());
			mv.addObject("roomhost_id", r.getRoomhost_id());
			mv.addObject("r_title", r.getR_title());
			mv.addObject("maxmemnum",r.getMaxmemnum());
			mv.addObject("gender",r.getGender());
			mv.addObject("thema",r.getThema());
			mv.addObject("entrancememnum",r.getRoommember().size());
			list.add(mv);
		}

		return list; 
	}


}
