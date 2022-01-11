package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.Optional;
import java.util.List;

public interface MemberRepository {
    Member save(Member member); // 회원저장
    Optional<Member> findById(Long id); // 회원조회
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 모든회원조회e
}
