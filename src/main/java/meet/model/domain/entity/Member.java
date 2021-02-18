package meet.model.domain.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	@OneToMany(mappedBy="uId")	//1:다 관계
	private List<QnA> qna;
//	private String local;
//	private String picturepath;
}
