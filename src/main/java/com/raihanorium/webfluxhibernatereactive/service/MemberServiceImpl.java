package com.raihanorium.webfluxhibernatereactive.service;

import com.raihanorium.webfluxhibernatereactive.model.Member;
import com.raihanorium.webfluxhibernatereactive.repository.MemberRepository;
import io.smallrye.mutiny.converters.multi.MultiReactorConverters;
import io.smallrye.mutiny.converters.uni.UniReactorConverters;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service("memberService")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MemberServiceImpl implements MemberService {

    @Nonnull
    private final MemberRepository memberRepository;

    @Override
    public Mono<List<Member>> getAllMembers() {
        return memberRepository.getAll()
                .convert()
                .with(UniReactorConverters.toMono());
    }

    @Override
    public Flux<Member> getAllMembersStream() {
        return memberRepository.getAllStream()
                .convert()
                .with(MultiReactorConverters.toFlux());
    }

    @Override
    public Mono<Member> save(Member member) {
        return memberRepository.save(member)
                .convert()
                .with(UniReactorConverters.toMono());
    }
}
