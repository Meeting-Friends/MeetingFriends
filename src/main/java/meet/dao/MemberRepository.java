package meet.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import meet.model.domain.entity.Member;


public interface MemberRepository extends JpaRepository<Member, String>{
	Optional<Member> findMemberByIdAndPw(String id, String pw);	//select * from member where id=? and pw=?;
}