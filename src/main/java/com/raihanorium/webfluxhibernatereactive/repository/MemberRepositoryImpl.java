package com.raihanorium.webfluxhibernatereactive.repository;

import com.raihanorium.webfluxhibernatereactive.model.Member;
import io.smallrye.mutiny.Uni;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.hibernate.reactive.mutiny.Mutiny;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MemberRepositoryImpl implements MemberRepository {

    @Nonnull
    private final Mutiny.SessionFactory sessionFactory;

    @Override
    public Uni<List<Member>> getAll() {
        return sessionFactory.withSession(session -> session
                .createQuery("from Member", Member.class)
                .getResultList());
    }
}
