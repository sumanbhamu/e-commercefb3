package com.suman.shopping.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.suman.shopping.dao.ProductDAO;
import com.suman.shopping.model.Product;

@Controller

public class AdminController {

	
		 @Autowired
		 ProductDAO productDAO;
		 
		 @RequestMapping("/adminhome")
			public String ShowAdminHome() {
				return "adminhome";
			}


		
		@RequestMapping("/addproduct")
		public String ShowAddProduct() {
			return "addproduct";
		}

		
		
		  @ModelAttribute 
		  public Product returnObject() {
			  return new Product();
		  
		  }
		  
		  @RequestMapping(value="/addprod",method=RequestMethod.POST)
		  public String ShowAddProduct(@Valid @ModelAttribute("product")Product product, Model
		  model,BindingResult result,HttpServletRequest request)throws IOException
		  {
		  System.out.println(product.getProd_name());
		  System.out.println("image uploaded");
		  System.out.println("myproduct controller called"); 
		  MultipartFile image=product.getImg();
		  Path path;//belong to nio package
		  path=Paths.get("E:/2016_project1/2016Projectfront/frontshop/src/main/webapp/resources/images/"+
		  product.getProd_name()+".jpg"); 
		  System.out.println("Path="+path);
		  System.out.println("File name"+product.getImg().getOriginalFilename());
		 if(image!=null&&!image.isEmpty())
		 { try {
			 image.transferTo(new File(path.toString()));
		  System.out.println("Image Saved in:"+path.toString()); 
		  } catch(Exception e)
		 { e.printStackTrace();
		 System.out.println("Image not saved");
		  
		  } } 
		 productDAO.savOrUpdate(product);
		  
		  
		  return "login"; }
		 

	

}
