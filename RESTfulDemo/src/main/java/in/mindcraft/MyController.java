package in.mindcraft;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	private List<Product> list = new ArrayList<>();
	
	
	public MyController() {
		list.add(new Product(101,"marker",40));
		list.add(new Product(102,"dell",50));
		list.add(new Product(103,"asus",60));
		
	}
		
//	@ResponseBody
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public List<Product> getProducts(){
		System.out.println("get all the products..");
		return list;	
	}
	
	@RequestMapping(value="products/{id}", method=RequestMethod.GET)  // for multiple ids
	public Product getProduct(@PathVariable int id) {
		for (Product p:list)
		{
			if(p.getLid()==id)
				return p;
			
		}
		return null;
	}
	

}