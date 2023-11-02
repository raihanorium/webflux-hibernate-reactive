package com.raihanorium.webfluxhibernatereactive.controller;

import com.raihanorium.webfluxhibernatereactive.MysqlConfiguration;
import com.raihanorium.webfluxhibernatereactive.model.Member;
import com.raihanorium.webfluxhibernatereactive.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
@TestPropertySource(locations="classpath:application.properties")
public class MemberControllerTest {

    @MockBean
    private MysqlConfiguration mysqlConfiguration;

    @MockBean
    private MemberService memberService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testMembersEndpointIsOk() throws Exception {
        mockMvc.perform(get("/members"))
                .andExpect(status().isOk());
    }

    @Test
    public void givenMembers_whenGetMembers_thenResponseIsOk()
            throws Exception {

        Member alex = new Member(1L, "Raihan", 11);

        Mono<List<Member>> allEmployees = Mono.just(List.of(alex));

        given(memberService.getAllMembers()).willReturn(allEmployees);

        mockMvc.perform(get("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
