package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //Spring JPA가 아래의 메소드를 SQL로 바꿔서 작성해준다
    //Select m from member m where m.name = ?;
    @Override
    Optional<Member> findByName(String name);

}

