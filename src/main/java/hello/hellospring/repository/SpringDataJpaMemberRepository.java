package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 인터페이스 다중상속 , spring bean에 등록해줌
// JpaRepository에 대부분의 함수들이 있음 (findAll...)
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
