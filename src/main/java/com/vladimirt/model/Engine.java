package com.vladimirt.model;


import lombok.*;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Engine {

    private String model;

    private int power;
}
