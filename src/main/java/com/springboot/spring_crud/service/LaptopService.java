package com.springboot.spring_crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.spring_crud.entity.Laptop;
@Service
public interface LaptopService {
	
	 List<Laptop> getAllLaptops();

	    Laptop getLaptopById(int id);

	    Laptop saveLaptop(Laptop laptop);

	    void updateLaptop(int id, Laptop laptop);

	    void deleteLaptop(int id);

}
