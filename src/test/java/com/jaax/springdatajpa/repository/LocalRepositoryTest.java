package com.jaax.springdatajpa.repository;

import com.jaax.springdatajpa.entity.Customer;
import com.jaax.springdatajpa.entity.Local;
import com.jaax.springdatajpa.entity.Manager;
import com.jaax.springdatajpa.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LocalRepositoryTest {

    @Autowired
    private LocalRepository localRepository;


    @Test
    public void saveLocal(){
        Manager manager = Manager.builder()
                .firstName("Juan")
                .lastName("Perez")
                .build();

        Local local = Local.builder()
                .name("PetShop")
                .floor("Second Floor")
                .manager(manager)
                .build();
        localRepository.save(local);
    }

    @Test
    public void findAllLocals(){
        List<Local> localList = localRepository.findAll();
        System.out.println("localList = " + localList);
    }

    @Test
    public void saveLocalWithOrders(){

        Manager manager = Manager.builder()
                .firstName("Juana")
                .lastName("Rodriguez")
                .build();

        Order order = Order.builder()
                .description("Entrada Pelicula 1 Sala 2 en 2D")
                .price(6.50)
                .build();

        Order order2 = Order.builder()
                .description("Entrada Pelicula 2 Sala 3 en 3D")
                .price(8.50)
                .build();

        Local local = Local.builder()
                .name("Cinema")
                .floor("Third Floor")
                .manager(manager)
                //.orderList(List.of(order,order2))
                .build();

        localRepository.save(local);

    }

    @Test
    public void findAllLocalsWithOrders(){
        List<Local> localList = localRepository.findAll();
        System.out.println("localList = " + localList);
    }

    @Test
    public void saveLocalWithCustomer(){
        Customer customer = Customer.builder()
                .firstName("Carl")
                .lastName("Jhonson")
                .email("carl@ejemplo.com")
                .build();
        Customer customer2 = Customer.builder()
                .firstName("Eddie")
                .lastName("Pulaski")
                .email("eddie@ejemplo.com")
                .build();


        Local local = Local.builder()
                .name("Clukin ' Bell")
                .floor("First Floor")
                .customerList(List.of(customer,customer2))
                .build();

        localRepository.save(local);
    }
    
    @Test
    public void findAllLocalsWithCustomers(){
        List<Local> localList = localRepository.findAll();
        System.out.println("localList = " + localList);
    }

    @Test
    public void findCustomersByLocal(){
        Local local = localRepository.findById(9L).get();
        List<Customer> customerList = local.getCustomerList();
        System.out.println("customerList = " + customerList);
    }



}