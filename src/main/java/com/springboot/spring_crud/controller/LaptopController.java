package com.springboot.spring_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.spring_crud.entity.Laptop;
import com.springboot.spring_crud.service.LaptopService;

@Controller
public class LaptopController {
	@Autowired
	private LaptopService laptopService;
	
	@PostMapping("/addlaptop")
	@ResponseBody
	public Laptop addLaptop(@RequestBody Laptop laptop) {
	    try {
	       
	        return laptopService.saveLaptop(laptop);
	    } catch (Exception e) {
	        e.printStackTrace();
	        
	        return null;
	    }
	}

    @PostMapping("/deleteLaptop/{id}")
    public String deleteLaptop(@PathVariable int id, Model model) {
        try {
            
            laptopService.deleteLaptop(id);

            
            List<Laptop> allLaptops = (List<Laptop>) laptopService.getAllLaptops();

            
            model.addAttribute("students", allLaptops);
            System.out.println(allLaptops);

        } catch (Exception e) {
            e.printStackTrace();
           
        }

        return "submitform";
    }
    
    
//    @GetMapping("/edit/{id}")
//    public String showEditForm(@PathVariable int id, Model model) {
//        Laptop laptop = laptopService.getLaptopById(id);
//        model.addAttribute("laptop", laptop);
//        return "edit";
//    }
//
//    
    
    
    
    @PostMapping("/updateLaptop/{id}")
    @ResponseBody
    public ResponseEntity<?> updateLaptop(@PathVariable int id, @RequestBody Laptop updatedlaLaptop) {
        try {
            
            updatedlaLaptop.setId(id);

           
            laptopService.updateLaptop(id, updatedlaLaptop);

           
            List<Laptop> allLaptops = (List<Laptop>) laptopService.getAllLaptops();

            return ResponseEntity.ok(allLaptops);

        } catch (Exception e) {
            e.printStackTrace();
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating student: " + e.getMessage());
        }
    }

}
