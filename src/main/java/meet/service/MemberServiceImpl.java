package meet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import meet.dao.MemberRepository;
import meet.domain.entity.Member;

@Service
public class MemberServiceImpl implements MemberService{
	MemberRepository mrepository;
	
	public List<Member> getMemberList();

	public void insertMember(Member member);

	public Member getMember(String id){
		return mrepository.findById(id).get();
		//	.orElseThrow(() -> new MemberNotFoundException(id+"검색 실패!!"));
	}

	public void updateMember(Member member);

	public void deleteMember(Member member);
}
