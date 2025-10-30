package org.bbdev.spring.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Map;

@NamedQuery(
        name = "Company.findByName",
        query = "select c from Company c where lower(c.name) = lower(:name)"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "company")
public class Company implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @ElementCollection
    @CollectionTable(name = "company_locales", joinColumns = @JoinColumn(name = "company_id"))
    @MapKeyColumn(name = "lang")
    @Column(name = "description")
    private Map<String, String> locales;

    public Company(Integer id) {
        this.id = id;
    }
}
