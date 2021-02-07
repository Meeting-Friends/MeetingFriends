package meet.service;

import java.util.List;

import meet.domain.entity.Member;

public interface MemberService {
	List<Member> getMemberList();

	void insertMember(Member member);

	Member getMember(String id);

	void updateMember(Member member);

	void deleteMember(Member member);
}
