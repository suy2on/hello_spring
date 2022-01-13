package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


//    private DataSource dataSource;

//    @Autowired
//    public SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }



//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em = em;
//    }


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository); // command + p : 인자들
    }

//    @Bean
//    public MemberRepository memberRepository(){
//      //  return new MemoryMemberRepository();  memory
//      //  return new JdbcMemberRepository(dataSource); 순수 jdb
//        //  return new JdbcTemplateMemberRepository(dataSource); // jdbc 템플릿
//           return new JpaMemberRepository(em);
//    }

}
