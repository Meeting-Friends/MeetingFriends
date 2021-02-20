package meet.service;

import java.util.List;

import meet.model.domain.entity.Comment;

public interface CommentService {
	
	List<Comment> getCommentList();	//전체 Comment들 리스트 가져오기
	
	Comment getComment(String id);
	
	boolean insertComment(Comment comment);

	boolean updateComment(Comment comment);

	boolean deleteComment(String id);
}
