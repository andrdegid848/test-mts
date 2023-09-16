package com.mts.testmts.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.atn.DecisionEventInfo;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tariffs")
@Builder
@Entity
public class Tariff implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private Integer price;
}
