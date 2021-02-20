package meet.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meet.dao.CommentRepository;
import meet.model.domain.entity.Comments;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentRepository commentrepository;

	//Comment리스트들을 반환하는 메소드
	public List<Comments> getCommentList(){
		return (List<Comments>) commentrepository.findAll();
	}

	public Comments getComment(String id){	
		try {
			return commentrepository.findById(id).get();			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Comment테이블에 저장하기 위한 메소드
	public boolean insertComment(Comments Comment) {
		try{
			SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
			Date time = new Date();
			Comment.setCreatedAt(format.format(time));			
			commentrepository.save(Comment);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//db의 Comment테이블을 수정하기 위한 메소드
	public boolean updateComment(Comments comment){	
		try {
			Comments findComment = commentrepository.findById(comment.getCommentId()).get();

			findComment.setContext(comment.getContext());
			SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
			Date time = new Date();
			findComment.setCreatedAt(format.format(time));					
			commentrepository.save(findComment);			
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//db의 Comment테이블을 삭제하기 위한 메소드
	public boolean deleteComment(String id) {
		try {
			commentrepository.deleteById(id);
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
