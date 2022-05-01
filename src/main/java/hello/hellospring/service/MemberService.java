package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service //컨테이너가 서비스 등록
public class MemberService {

    private final MemberRepository memberRepository;

    //@Autowired //spring 컨테이너가 생성자 호출 -> spring 컨테이너에 있는 객체를 넣어줌
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public Long join(Member member){
        //이름 중복 회원 X
        validateDuplicateMember(member);

        memberRepository.save(member);
        return  member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
              .ifPresent(m ->{ //optional이기 때문에 가능
                    throw  new IllegalStateException("이미 존재하는 회원 입니다.");
              });
    }

    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
