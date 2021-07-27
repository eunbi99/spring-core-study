package hello.core.member;

public class MemberServiceImpl implements MemberService  {

    //더이상 MemberServiceImpl은 MemoryMemberRepository를 의존하지 않는다.
    private final MemberRepository memberRepository; //단지 MemberRepository 인터페이스만 의존!

    //생성자를 통해 어떤 구현 객체가 주입될지 알 수 없다. (AppConfig에서 결정됨)
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    @Override
    public void join(Member member){
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId){
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
