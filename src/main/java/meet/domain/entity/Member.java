package meet.domain.entity;

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
	private String nickname;
	private String phonenumber;
	private String birth;
	private String gender;
	private String local;
	private String classification;
	private String picturepath;
}
