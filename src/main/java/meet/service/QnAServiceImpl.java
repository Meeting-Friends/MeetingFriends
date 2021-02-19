package meet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meet.dao.QnARepository;
import meet.model.domain.entity.QnA;

@Service
public class QnAServiceImpl implements QnAService{
	@Autowired
	private QnARepository qnarepository;

	//qna리스트들을 반환하는 메소드
	public List<QnA> getnQnAList(){
		return (List<QnA>) qnarepository.findAll();
	}

	//qna테이블에 저장하기 위한 메소드
	public void insertQnA(QnA qna) {
		qnarepository.save(qna);
	}

	//db의 qna테이블을 수정하기 위한 메소드
	public void updateQnA(QnA qna){	
		QnA findqna = qnarepository.findById(qna.getSeqnum()).get();

		findqna.setAnswer(qna.getAnswer());
		
		qnarepository.save(findqna);
	}
	public void deleteQnA(QnA qna) {
		qnarepository.deleteById(qna.getSeqnum());
	}
}
