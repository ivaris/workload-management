package com.wawa.service;


import com.wawa.model.Group;
import com.wawa.model.Member;
import com.wawa.repository.MemberRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class MemberServiceImplTest {

    @InjectMocks
    MemberServiceImpl memberService;
    @Mock
    MemberRepository memberRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ok(){
        Member member = new Member();
        member.setId(1);
        when(memberRepository.getMemberbyId(anyInt())).thenReturn(member);
        Mono<Member> result = memberService.loadMember(1);
        assertTrue(result.block().getId()==1);
        assertTrue(result.block().getGroups().size()==0);

    }
    @Test
    public void okwithgroups(){
        Member member = new Member();
        member.setId(1);
        List<Group> groups = new ArrayList<>();
        groups.add(new Group());
        groups.add(new Group());
        member.setGroups(groups);
        when(memberRepository.getMemberbyId(anyInt())).thenReturn(member);
        Mono<Member> result = memberService.loadMember(1);
        assertTrue(result.block().getId()==1);
        assertTrue(result.block().getGroups().size()==2);

    }
    @Test(expected = RuntimeException.class)
    public void exception(){
        Member member = new Member();
        when(memberRepository.getMemberbyId(anyInt())).thenThrow(new RuntimeException());
        Mono<Member> result = memberService.loadMember(1);
        assertTrue(result.block().getId()==1);

    }
}
