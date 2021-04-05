package SpringBasic.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository; // = new MemberRepository() --> 생성자 주입
    /* MemberServiceImpl 내부에 MemberRepository는 Interface 의존
    + MemoryMemberRepository -> 구현체를 의존 (둘 다 의존? -> 변경 있을시 문제가 될 수 있음)
    * DIP 위반!!*/
    @Autowired // Spring에 의해 DI 관리됨. 의존관계 명시
    // AppConfig와 다르게 설정정보 자체가 Config에 없어서 이런식으로 명시함.
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public void join(Member member) {
        memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //TEST 용도, Singleton(MemberRepository) 디자인패턴 만족되는지
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}