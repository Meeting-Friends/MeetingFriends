package meet.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import meet.model.domain.entity.QnA;


public interface QnARepository extends JpaRepository<QnA, String>{


}