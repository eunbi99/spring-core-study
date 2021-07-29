package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService  {

    //더이상 MemberServiceImpl은 MemoryMemberRepository를 의존하지 않는다.
    private final MemberRepository memberRepository; //단지 MemberRepository 인터페이스만 의존!

    @Autowired
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
