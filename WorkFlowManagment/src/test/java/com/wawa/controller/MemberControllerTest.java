package com.wawa.controller;

import com.wawa.model.Member;
import com.wawa.service.MemberService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class MemberControllerTest {
    @InjectMocks
    MemberController sut;

    @Mock
    MemberService memberService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = RuntimeException.class)
    public void login_badRequest(){
        sut.login(null,null);
    }

    @Test(expected = RuntimeException.class)
    public void login_invalidUserId(){
        sut.login(0,null);
    }

    @Test(expected = RuntimeException.class)
    public void login_serviceException(){
        when(memberService.loadMember(anyInt())).thenReturn(Mono.error(new Exception("Server Exception")));
        Member member = sut.login(110,null);
        assertTrue(member==null);
    }

    @Test
    public void login_MemberNotFound(){
        when(memberService.loadMember(anyInt())).thenReturn(Mono.empty());
        Member member = sut.login(110,null);
        assertTrue(member==null);
    }

    @Test
    public void login_MemberOk(){
        Member member = new Member();
        member.setName("test");
        when(memberService.loadMember(anyInt())).thenReturn(Mono.just(member));
        Member result =  sut.login(110,null);
        assertTrue(result!=null);
    }

}
