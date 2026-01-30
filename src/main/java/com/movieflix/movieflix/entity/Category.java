package com.movieflix.movieflix.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder //PRECISA DO AllArgs e do NoArgs
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="name", length = 100, nullable = false) //nullable faz com que o nome seja OBRIGATÓRIO
    private String name;


}
