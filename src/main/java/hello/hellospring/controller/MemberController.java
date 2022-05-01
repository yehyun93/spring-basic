package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //spring 컨테이너가 뜰때 이 생성자를 호출
    // spring bean에 가지고 있는 객체를 넣어 (DI)
    public MemberController(MemberService memberService) {
        // spring 컨테이너가 관리하는 service 객체를 넘겨줌
        this.memberService = memberService;
    }
}

