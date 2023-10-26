package com.raihanorium.webfluxhibernatereactive.controller;

import com.raihanorium.webfluxhibernatereactive.model.Member;
import com.raihanorium.webfluxhibernatereactive.service.MemberService;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
