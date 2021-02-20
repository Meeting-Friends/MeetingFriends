package meet.model.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Comment {	
	@Id @GeneratedValue
	private String commentId;
	private String context;
	private String createdAt;
	private String updatedAt;
	
	@ManyToOne
	@JoinColumn(name="m_id")
	private Member uId;

	@ManyToOne
	@JoinColumn(name="content_id")
	private Content contentId;
}
