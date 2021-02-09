package meet.model.domain.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Component
public class Room {
	private String r_id;	//방 id
	private String roomhost_id;	//방장 id
	//private List<String> list;
	//private String r_pw;
	private String r_title;
	private int maxmemnum;
	private String agegroup;
	private String gender;
	@Autowired
	private Theme thema;
}
