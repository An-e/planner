package pl.coderslab.planner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

enum CategoryName {
    DAILYROUTINES,
    WORK,
    EDUCATION,
    ENTERTAINMENT
}

@Getter
@Setter
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private CategoryName name;
}
