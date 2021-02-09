package meet.model.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

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
@Entity
public class Member {
	@Id
	private String id;
	private String pw;
	private String name;
	private String nickname;
	private String phonenumber;
	private String birth;
	private String gender;
	private String classification;	//권한(ex. 관리자, 일반회원)
//	private String local;
//	private String picturepath;
}
