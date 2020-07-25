package com.wawa.controller;

import com.wawa.model.Member;
import com.wawa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("login/v1")
    public Member login(
            @RequestHeader("userId") Integer userId, @RequestHeader("password") String password
    ) {
        System.out.println("discarded password");
        if(userId== null || userId<1){
            throw new RuntimeException("Bad Request");
        }
        return memberService.loadMember(userId).map(result->{
            if(result==null){
                throw new RuntimeException("Not Found");
            }
            return result;
        }).block();
    }

    @GetMapping("")
    public String get(){
        return Mono.just("member-service").block();
    }

}
