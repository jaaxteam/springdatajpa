package com.jaax.springdatajpa.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_customer",
        uniqueConstraints = @UniqueConstraint(
                name = "email_unique",
                columnNames = "email_address"
        )
)
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_secuence",
            sequenceName = "customer_secuence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_secuence"
    )
    private Long customerId;

    private String firstName;
    private String lastName;

    @Column(
            name = "email_address",
            nullable = false
    )
    private String email;

//    private String customerCity;
//    private String customerMainStreet;
//    private String customerSecondaryStreet;

    @Embedded
    private Address address;
}
