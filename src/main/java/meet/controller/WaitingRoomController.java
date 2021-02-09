package meet.controller;

import java.util.List;

import org.springframework.web.bind.annotation.SessionAttributes;

import meet.model.domain.entity.Member;

@SessionAttributes({"loginmemberlist"})
public class WaitingRoomController {
	List<Member> waitingroommemberlist;	//로그인된 멤버들 리스트 관리
}
