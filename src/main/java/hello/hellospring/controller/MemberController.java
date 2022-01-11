package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // spring container가 관리 (스프링빈등록)
public class MemberController {

    private final MemberService memberService;

    //생성자
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
