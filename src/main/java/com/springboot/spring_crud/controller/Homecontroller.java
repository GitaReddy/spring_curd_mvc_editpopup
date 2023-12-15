package com.springboot.spring_crud.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.spring_crud.entity.Laptop;
import com.springboot.spring_crud.service.LaptopService;

@Controller

public class Homecontroller {
	
		
	@Autowired
	private LaptopService laptopService;
	
	
    public Homecontroller(LaptopService laptopService) {
        this.laptopService = laptopService;
    }
	
	
    @GetMapping("/")
    public String getAllLaptops(Model model) {
        List<Laptop> laptops = laptopService.getAllLaptops();
        model.addAttribute("laptops", laptops);
        return "submitform";
    }
    
    @PostMapping("/save")
    public String saveLaptop(@ModelAttribute Laptop laptop, Model model) {
  
        laptopService.saveLaptop(laptop);
        List<Laptop> list = laptopService.getAllLaptops();
        model.addAttribute("list", list);
        
        System.out.println(list);
        return "submitform";
    }

    
    @GetMapping("/submitform")
    public String showSubmitForm(Model model) {
    	List<Laptop> list = laptopService.getAllLaptops();
        model.addAttribute("list", list);
        return "submitform";
    }

    @GetMapping("/alllaptops")
    @ResponseBody
    public List<Laptop> getAllLaptopJson() {
        try {
            // Return the list of all students as JSON
            return (List<Laptop>) laptopService.getAllLaptops();
        } catch (Exception e) {
            e.printStackTrace();
            // Log the exception using a logger
            // Handle the exception appropriately, e.g., return an empty list or an error message
            return Collections.emptyList();
        }
    }
    
    
    
    
    
    
//    @GetMapping("/edit/{id}")
//    public String showEditForm(@PathVariable int id, Model model) {
//        Laptop laptop = laptopService.getLaptopById(id);
//        model.addAttribute("laptop", laptop);
//        return "edit";
//        
//    }
//
//    @PostMapping("/update")
//    public String updateLaptop(@PathVariable int id, @ModelAttribute Laptop updatedLaptop, Model model) {
//        laptopService.updateLaptop(id, updatedLaptop);
//        List<Laptop> list = laptopService.getAllLaptops();
//        model.addAttribute("list", list);
//        return "submitform";
//        
//    }
//    
//
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteLaptop(@PathVariable int id,Model model) {
//        laptopService.deleteLaptop(id);
//        List<Laptop> list = laptopService.getAllLaptops();
//        model.addAttribute("list", list);
//        return "submitform";
//    }
}
