package meet.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import meet.model.domain.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, String>{
}