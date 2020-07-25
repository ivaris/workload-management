package com.wawa.service;

import com.wawa.model.Member;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface MemberService {
   Mono<Member> loadMember(Integer id);
}
