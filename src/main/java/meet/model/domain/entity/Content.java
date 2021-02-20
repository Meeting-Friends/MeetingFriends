package meet.model.domain.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Content {	
	@Id @GeneratedValue
	private String contentId;
	private String category;
	private String title;
	private String context;
	private String createdAt;
	private String updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="m_id")
	private Member uId;
	
	@OneToMany(mappedBy="contentId")	//1:다 관계
	private List<Comments> comment;
}
