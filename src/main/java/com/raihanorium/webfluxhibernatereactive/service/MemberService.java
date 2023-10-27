package com.raihanorium.webfluxhibernatereactive.service;

import com.raihanorium.webfluxhibernatereactive.model.Member;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MemberService {

    Mono<List<Member>> getAllMembers();

    Mono<Member> save(Member member);
}
