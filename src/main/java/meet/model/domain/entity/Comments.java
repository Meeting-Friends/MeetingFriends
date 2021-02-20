package meet.model.domain.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Entity
public class Comments {	
	@Id @GeneratedValue
	private String commentId;
	private String context;
	private String createdAt;
	private String updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="m_id")
	private Member uId;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="content_id")
	private Content contentId;
}
