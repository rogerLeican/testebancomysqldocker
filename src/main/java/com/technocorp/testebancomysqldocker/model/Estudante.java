package com.technocorp.testebancomysqldocker.model;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

//@Builder
//@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude ={"name","estudanteList"})
public class Estudante {
    private int id;
    private String name;
    public static List<Estudante> estudanteList;


    static {
        estudanteRepository();
    }


    private static void estudanteRepository() {
        estudanteList = new ArrayList<>(asList(new Estudante(1, "Roger"), new Estudante(2, "Aline")));
    }


}
