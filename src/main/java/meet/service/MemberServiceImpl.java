package meet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import meet.dao.MemberRepository;
import meet.exception.MemberNotFoundException;
import meet.exception.NullOfInfoException;
import meet.model.domain.entity.Member;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberRepository mrepository;

	//adminpage에서 사용하기 위한 메소드로서 전체 회원들을 리스트로 반환하는 메소드
	public List<Member> getMemberList(){
		return (List<Member>) mrepository.findAll();
	}

	//회원가입 가능 여부 체크 메소드
	public boolean checkExistingMember(String id) {	
		Optional<Member> findMember = mrepository.findById(id);
		if(findMember.isPresent()){	//이미 존재하는 id라면 회원가입 불가
			return false;
		}else {			//회원가입 가능, id만 중복되지 않으면 가능!
			return true;
		}
	}
	
	//회원가입 가능 체크후 호출되는 메소드로서 db member테이블에 저장하기 위한 메소드
	public void insertMember(Member member) {
		mrepository.save(member);
		log.info(member.getId()+"회원가입완료!!");
	}

	//로그인 가능 여부 체크 메소드
	public Member checkMember(String id,String pw) {
		try {
			if(id == null || pw == null) {
				throw new NullOfInfoException("로그인시 입력한 id, pw 정보누락!");
			}
			return mrepository.findMemberByIdAndPw(id,pw)
					.orElseThrow(() -> new MemberNotFoundException("로그인  실패!!"));				
		} catch (MemberNotFoundException e) {
			log.warn(e.getMessage()+"  "+id+"/ "+pw+"정보로 로그인 시도");
			e.printStackTrace();
		} catch (NullOfInfoException e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	//db의 member테이블을 수정하기 위한 메소드
	public void updateMember(Member member){	
		Member findMember = mrepository.findById(member.getId()).get();
		
		//nickname, phonenumber, pw만 업데이트 가능
		findMember.setNickname(member.getNickname());
		findMember.setPhonenumber(member.getPhonenumber());
		findMember.setPw(member.getPw());
		mrepository.save(findMember);
	}
	public void deleteMember(Member member) {
		mrepository.deleteById(member.getId());
	}
}
