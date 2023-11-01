package com.raihanorium.webfluxhibernatereactive.controller;

import com.raihanorium.webfluxhibernatereactive.model.Member;
import com.raihanorium.webfluxhibernatereactive.service.MemberService;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MemberController {

    @Nonnull
    private final MemberService memberService;

    @GetMapping
    public Mono<ResponseEntity<List<Member>>> getMembers() {
        return memberService.getAllMembers()
                .map(ResponseEntity::ok);
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Member> getMembersStream() {
        return memberService.getAllMembersStream();
    }

    @PostMapping
    public Mono<ResponseEntity<Member>> createMember(@RequestBody Member member) {
        return memberService.save(member)
                .map(ResponseEntity::ok);
    }
}
