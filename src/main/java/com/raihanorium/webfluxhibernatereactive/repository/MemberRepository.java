package com.raihanorium.webfluxhibernatereactive.repository;

import com.raihanorium.webfluxhibernatereactive.model.Member;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface MemberRepository {

    Uni<List<Member>> getAll();
}
