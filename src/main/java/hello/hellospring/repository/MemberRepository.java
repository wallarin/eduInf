package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository { //?
    
    //4가지의 기능
    // Optional >> Null값을 처리하기 위한 방법 중 하나이다.(요즘 선호)

    Member save(Member member); //회원정보를 저장하는 기능
    
    /* 회원의 아이디 or 이름 찾기 기능 */ 
    Optional<Member> findById(Long id); 
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
