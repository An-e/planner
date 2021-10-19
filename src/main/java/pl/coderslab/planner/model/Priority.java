package pl.coderslab.planner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

enum PriorityName {
    VERYHIGH,
    HIGH,
    MEDIUM,
    LOW
}

@Getter
@Setter
@Entity
public class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name="name")
    private PriorityName name;
}
