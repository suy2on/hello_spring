package hello.hellospring.service; // 좀더 비즈니스적인 코드

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService { // command + shift + T : test 자동생성
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member){

        // 동명이인 불가 ( command + option + v : 값을 받을 변수 생성 )
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    // ctrl + T : 함수추출
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) // optional 자료형
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 이름입니다");
                 });
    }

    // 전체회원조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    // 특정회원조회
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}

