package com.simplilearn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

@Data @NoArgsConstructor@AllArgsConstructor
public class RegularEmployee extends Employee{

    private float salary;
    private float bonus;

}
