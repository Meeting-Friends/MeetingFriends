package meet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import meet.model.domain.entity.Content;

public interface ContentRepository extends JpaRepository<Content, String>{
}