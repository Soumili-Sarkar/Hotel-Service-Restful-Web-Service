package com.cognizant.HotelService.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.HotelService.bean.MenuItem;
@RestController
public class MenuController {

   public static Map<Integer, MenuItem> menuItemList = new HashMap<>();
   static {
	   MenuItem menu1 = new MenuItem();
	  menu1.setId(1);
      menu1.setName("Chicken Momo");
      menu1.setPrice(100);
      menuItemList.put(menu1.getId(), menu1);
      
      MenuItem menu2 = new MenuItem();
      menu2.setId(2);
      menu2.setName("Chocolate Icecream");
      menu2.setPrice(70);
      menuItemList.put(menu2.getId(), menu2);
      
      MenuItem menu3 = new MenuItem();
      menu3.setId(3);
      menu3.setName("Cold Drink");
      menu3.setPrice(55);
      menuItemList.put(menu3.getId(), menu3);
   }
  
       @RequestMapping(value = "/menuitem")
      public ResponseEntity<Object> getProduct() {
         return new ResponseEntity<>(menuItemList.values(), HttpStatus.OK);
      }  
       
       @GetMapping("/menuitem/{id}")
       public ResponseEntity<Object> getById(@PathVariable("id") int id) {
    	   MenuItem p=menuItemList.get(id);
    	   return new ResponseEntity<Object>(p, HttpStatus.OK);
       }
       @RequestMapping(value = "/menuitem/{id}", method = RequestMethod.PUT)
       public ResponseEntity<Object> updateProduct(@PathVariable("id") int id, @RequestBody MenuItem menuItem) { 
    	   menuItemList.remove(id);
    	   menuItem.setId(id);
    	   menuItemList.put(id, menuItem);
          return new ResponseEntity<>("Menu is updated.", HttpStatus.OK); 
          }
       @PostMapping("/menuitem")
       public ResponseEntity<Object> createProduct(@RequestBody MenuItem menuItem) {
    	  menuItemList.put(menuItem.getId(), menuItem);
          return new ResponseEntity<>("Menu is added.", HttpStatus.CREATED);
       }
       
       @RequestMapping(value = "/menuitem/{id}", method = RequestMethod.DELETE)
       public ResponseEntity<Object> delete(@PathVariable("id") int id) 
       { 
    	   menuItemList.remove(id);
             return new ResponseEntity<>("Menu is removed.", HttpStatus.OK);  
        }
      
       
}


   