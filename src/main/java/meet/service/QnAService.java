package meet.service;

import java.util.List;

import meet.model.domain.entity.QnA;

public interface QnAService {
	List<QnA> getnQnAList();	//전체 QnA들 리스트 가져오기
	
	void insertQnA(QnA qna);

	void updateQnA(QnA qna);

	void deleteQnA(QnA qna);
}
