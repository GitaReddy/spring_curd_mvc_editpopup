package com.springboot.spring_crud.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.spring_crud.entity.Laptop;

@Repository
public interface Laptoprepo extends MongoRepository<Laptop, Integer> {

}
