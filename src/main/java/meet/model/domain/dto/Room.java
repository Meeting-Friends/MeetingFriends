package meet.model.domain.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	private String title;
	private int maxpeople;
	private String theme;
	private int minage;
	private int maxage;
	private String gender;
	private List<Member> roommember=new ArrayList<Member>();
}
