package meet.dao;

import org.springframework.data.repository.CrudRepository;

import meet.domain.entity.Member;


public interface MemberRepository extends CrudRepository<Member, String> {
	
}
