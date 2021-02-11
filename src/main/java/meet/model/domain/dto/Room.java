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
	private String r_id;	//방 id
	private String roomhost_id;	//방장 id
	private String r_title;
	private int maxmemnum;
	private String agegroup;
	private String gender;
	@Autowired
	private Theme thema;
	private List<Member> roommember=new ArrayList<Member>();
}
