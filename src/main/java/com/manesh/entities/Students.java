package com.manesh.entities;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @NotBlank(message = "Name cannot be empty")
    private String name;
    @NotNull(message = "Number cannot be empty")
    private Long number;

}
