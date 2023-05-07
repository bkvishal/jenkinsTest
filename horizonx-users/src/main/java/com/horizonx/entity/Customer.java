package com.horizonx.entity;



import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer{

    private Long custId;
    private String customerName;
    private String address;
    private String country;
    private int age;

}
