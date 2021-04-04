package SpringBasic.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository; // = new MemberRepository() --> 생성자 주입
    /* MemberServiceImpl 내부에 MemberRepository는 Interface 의존
    + MemoryMemberRepository -> 구현체를 의존 (둘 다 의존? -> 변경 있을시 문제가 될 수 있음)
    * DIP 위반!!*/

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