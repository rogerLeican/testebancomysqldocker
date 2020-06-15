package com.technocorp.testebancomysqldocker.model;


import lombok.*;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

//@Builder
//@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Estudante extends AbstractEntity {
//    private int id;
    private String name;

}
