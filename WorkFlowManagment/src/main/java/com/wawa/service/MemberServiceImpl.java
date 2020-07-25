package com.wawa.service;

import com.wawa.model.Member;
import com.wawa.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;
    @Override
    public Mono<Member> loadMember(Integer id) {
        return Mono.just(memberRepository.getMemberbyId(id)).onErrorResume(err->{
            err.printStackTrace();
            return Mono.error(err);
        });
    }
}
