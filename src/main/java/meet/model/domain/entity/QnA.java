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
public class QnA {	
	@Id @GeneratedValue
	private String seqnum;
	private String title;
	private String content;
	private String answer;
	
	@ManyToOne
	@JoinColumn(name="m_id")
	private Member uId;
}
