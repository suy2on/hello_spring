package hello.hellospring;

import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository()); // command + p : 인자들
    }

    @Bean
    public MemberRepository memberRepository(){
      //  return new MemoryMemberRepository();  memory
      //  return new JdbcMemberRepository(dataSource); 순수 jdbc
        return new JdbcTemplateMemberRepository(dataSource); // jdbc 템플릿
    }

}
