package com.khasanov.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "country", schema = "world")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 3, nullable = false)
    private String code;

    @Column(name = "code_2", length = 3, nullable = false)
    private String alternativeCode;

    @Column(length = 52, nullable = false)
    private String name;

    @Column(name = "continent", nullable = false, columnDefinition = "int")
    @Enumerated(EnumType.ORDINAL)
    private Continent continent;

    @Column(length = 26, nullable = false)
    private String region;

    @Column(name = "surface_area", nullable = false, precision = 10, scale = 2)
    private BigDecimal surfaceArea;

    @Column(name = "indep_year")
    private Short independenceYear;

    @Column(nullable = false)
    private Integer population;

    @Column(name = "life_expectancy", precision = 3, scale = 1)
    private BigDecimal lifeExpectancy;

    @Column(name = "gnp", precision = 10, scale = 2)
    private BigDecimal GNP;

    @Column(name = "gnpo_id", precision = 10, scale = 2)
    private BigDecimal GNPOId;

    @Column(name = "local_name", length = 45, nullable = false)
    private String localName;

    @Column(name = "government_form", length = 45, nullable = false)
    private String governmentForm;

    @Column(name = "head_of_state", length = 60)
    private String headOfState;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "capital")
    @ToString.Exclude
    private City capital;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Set<CountryLanguage> languages;
}
