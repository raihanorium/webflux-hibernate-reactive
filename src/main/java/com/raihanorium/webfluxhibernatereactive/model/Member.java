package com.raihanorium.webfluxhibernatereactive.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "member")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member implements Serializable {
    @Serial
    private static final long serialVersionUID = 8639722432182619877L;

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "member_name")
    private String name;

    @Column(name = "age")
    private Integer age;
}
