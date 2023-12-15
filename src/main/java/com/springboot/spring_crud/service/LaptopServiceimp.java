package com.springboot.spring_crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.spring_crud.entity.Laptop;
import com.springboot.spring_crud.repository.Laptoprepo;
@Service
public class LaptopServiceimp implements LaptopService{
	@Autowired
	private Laptoprepo laptoprepo;
	
	 
	    public LaptopServiceimp(Laptoprepo laptoprepo) {
	        this.laptoprepo= laptoprepo;
	    }

	@Override
	public List<Laptop> getAllLaptops() {
		return laptoprepo.findAll();
		
	}

	@Override
	public Laptop getLaptopById(int id) {
		
		 Optional<Laptop> optionalLaptop = laptoprepo.findById(id);
	        return optionalLaptop.orElse(null);
	}

	@Override
	public Laptop saveLaptop(Laptop laptop) {
		 return laptoprepo.save(laptop);
		
	}

	@Override
	public void updateLaptop(int id, Laptop laptop1) {
		 Optional<Laptop> optionalLaptop = laptoprepo.findById(id);
	        if (optionalLaptop.isPresent()) {
	            Laptop laptop = optionalLaptop.get();
	            laptop.setBrand(laptop1.getBrand());
	            laptop.setPrice(laptop1.getPrice());
	            laptoprepo.save(laptop);
	        }
		
	}

	@Override
	public void deleteLaptop(int id) {
		 laptoprepo.deleteById(id);
		
	}

}
