package com.jaax.springdatajpa.repository;

import com.jaax.springdatajpa.entity.Address;
import com.jaax.springdatajpa.entity.Customer;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void saveCustomer(){
        Customer customer = Customer.builder()
                .firstName("Jaax")
                .lastName("Team")
                .email("jaax@ejemplo.com")
                .build();

        customerRepository.save(customer);
    }

    @Test
    public void saveCustomerWithAddressEmbedded(){

        Address address = Address.builder()
                .city("Ambato")
                .mainStreet("Ambato Simon Bolivar")
                .secondaryStreet("Maldonado")
                .build();

        Customer customer = Customer.builder()
                .firstName("Juan")
                .lastName("Perez")
                .email("juan@ejemplo.com")
                .address(address)
                .build();

        customerRepository.save(customer);
    }

    @Test
    public void findCustomerByFirstName(){
        Customer customer = customerRepository.findByFirstName("Alex").get();
        System.out.println("customer = " + customer);
    }

    @Test
    public void findAllCustomers(){
        List<Customer> customerList = customerRepository.findAll();
        System.out.println("customerList = " + customerList);
    }
    
    
    @Test
    public  void findAllCustomersFirstNameContainig(){
        List<Customer> customerList = customerRepository.findByFirstNameContaining("Al");
        System.out.println("customerList = " + customerList);
    }

    @Test
    public void findAllCustomersLastNameNotNull(){
        List<Customer> customerList = customerRepository.findByLastNameNotNull();
        System.out.println("customerList = " + customerList);
    }

    @Test
    public void findAllCustomersByAddressCity(){
        List<Customer> customerList = customerRepository.findByAddress_City("Ambato");
        System.out.println("customerList = " + customerList);
    }

    @Test
    public void getCustomerByEmailAddress(){
        Customer customer = customerRepository.getCustomerByEmailAddress("juan@ejemplo.com");
        System.out.println("customer = " + customer);
    }
    
    @Test
    public void getCustomerFirstNameByEmailAddress(){
        String firstName = customerRepository.getCustomerFirstNameByEmailAddress("juan@ejemplo.com");
        System.out.println("firstName = " + firstName);
    }

    @Test
    public void getCustomerByEmailAddressNative(){
        Customer customer = customerRepository.getCustomerByEmailAddressNative("juan@ejemplo.com");
        System.out.println("customer = " + customer);
    }

    @Test
    public void getCustomerByEmailAddressNativeNamedParam(){
        Customer customer = customerRepository.getCustomerByEmailAddressNativeNamedParam("juan@ejemplo.com");
        System.out.println("customer = " + customer);
    }

    @Test
    public void updateCustomerNameByEmail(){
        customerRepository.updateCustomerNameByEmail("Juan","juan@ejemplo.com");
    }
    
}