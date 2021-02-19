package meet.model.domain.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import meet.model.domain.entity.Member;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Component
@Scope("Prototype")
public class Room {
	private String rId;	//방 id
	private String title;	//방제목
	private int maxPeople;	//최대인원
	private String theme;	//테마
	private String gender;	//성별
	private List<Member> roommember=new ArrayList<Member>();
}
