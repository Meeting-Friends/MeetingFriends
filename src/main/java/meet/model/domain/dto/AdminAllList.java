package meet.model.domain.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import meet.model.domain.entity.Member;

@Getter
@Component
public class AdminAllList {
	private List<Member> loginMemberList = new ArrayList<Member>();	//로그인된 멤버들 리스트 관리
	private List<Room> RoomList  = new ArrayList<Room>();	//생성된 방 리스트 관리
}
