package com.wawa.controller;

import com.wawa.model.Member;
import com.wawa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("login/v1")
    public CompletableFuture<Member> login(
            @RequestHeader("userId") Integer userId, @RequestHeader("password") String password
    ) {
        System.out.println("discarded password");
        return memberService.loadMember(userId).toFuture();
    }

    @GetMapping("")
    public CompletableFuture<String> get(){
        return Mono.just("member-service").toFuture();
    }

}
