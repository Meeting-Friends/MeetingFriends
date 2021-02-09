package meet.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import meet.model.domain.entity.Member;


public interface MemberRepository extends CrudRepository<Member, String> {
	Optional<Member> findMemberByIdAndPw(String id, String pw);	//select * from member where id=? and pw=?;
}