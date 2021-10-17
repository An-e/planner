package pl.coderslab.planner.model;

import javax.persistence.*;

enum PriorityName {
    VERYHIGH,
    HIGH,
    MEDIUM,
    LOW
}


@Entity
public class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name="name")
    private PriorityName name;
}
