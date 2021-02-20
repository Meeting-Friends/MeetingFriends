package meet.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import meet.model.domain.entity.Comments;

public interface CommentRepository extends JpaRepository<Comments, String>{
}