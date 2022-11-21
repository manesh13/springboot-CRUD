package com.manesh.entities;

import lombok.*;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Builder
@Data
@AllArgsConstructor
@Table(name = "Students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String name;
    private Long number;

}
