package meet.service;

import java.util.List;

import meet.model.domain.entity.Comments;

public interface CommentService {
	
	List<Comments> getCommentList();	//전체 Comment들 리스트 가져오기
	
	Comments getComment(String id);
	
	boolean insertComment(Comments comment);

	boolean updateComment(Comments comment);

	boolean deleteComment(String id);
}
