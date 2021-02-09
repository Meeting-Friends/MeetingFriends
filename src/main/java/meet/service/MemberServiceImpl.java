package meet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import meet.dao.MemberRepository;
import meet.exception.MemberNotFoundException;
import meet.exception.NullOfInfoException;
import meet.model.domain.entity.Member;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService{
	MemberRepository mrepository;
	
	public List<Member> getMemberList(){
		return (List<Member>) mrepository.findAll();
	}
	
	public boolean checkExistingMember(String id) {
		if(mrepository.findById(id).equals(Optional.empty())) {		//회원가입 가능
			return true;
		}else {
			return false;
		}
	}
	
	public void insertMember(Member member) {
		mrepository.save(member);
		log.info(member.getId()+"회원가입완료!!");
	}

	public Member checkMember(String id,String pw) {
		try {
			if(id == null || pw == null) {
				throw new NullOfInfoException("로그인시 입력한 id, pw 정보누락!");
			}
			return mrepository.findMemberByIdAndPw(id,pw)
					.orElseThrow(() -> new MemberNotFoundException("로그인  실패!!"));				
		} catch (MemberNotFoundException e) {
			log.warn(e.getMessage()+"  "+id+"/"+pw+"정보로 로그인 시도");
			e.printStackTrace();
		} catch (NullOfInfoException e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public void updateMember(Member member){
		
	}
	public void deleteMember(Member member) {
		
	}
}
