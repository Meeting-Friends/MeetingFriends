package meet.service;

import java.util.List;
import java.util.Optional;

import meet.model.domain.entity.Member;

public interface MemberService {
	List<Member> getMemberList();	//전체 회원들 리스트 가져오기
	
	boolean checkExistingMember(String id);

	void insertMember(Member member);

	Member checkMember(String id,String pw);

	void updateMember(Member member);

	void deleteMember(Member member);

	Member getMemberInfo(String id);
}
