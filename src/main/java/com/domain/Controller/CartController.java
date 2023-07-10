package com.domain.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.domain.Cart.Cart;
import com.domain.OrderLine.OrderLine;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/carts")
	public List<Cart> findAllCarts(){ 
		return cartService.findAllCarts();
	}
	
	@GetMapping("/carts/{id}")
	public Cart findCartById(@PathVariable int id){ 
		return cartService.findCartById(id);
	}
	
	@GetMapping("/consumer-cart/{consumerId}")
	public Cart findCartByConsumerId(@PathVariable int consumerId){ 
		return cartService.findCartByConsumerId(consumerId);
	}
	
	@PostMapping("/carts")
	public Cart insertCart(@RequestBody Cart cartObj){
		return cartService.insertCart(cartObj);
	}
	
	@PutMapping("/carts")
	public Cart updateCart(@RequestBody Cart cartObj){
		Cart cart = cartService.findCartById(cartObj.getCartId());
		return cartService.updateCart(cartObj, cart);
	}
	
	
	@DeleteMapping("/carts/{id}")
	public void deleteCart(@PathVariable int id) {
		Cart cart = cartService.findCartById(id);
		cartService.deleteCart(cart);
	}
	
	@GetMapping("/orders")
	public List<OrderLine> findAllOrders(){
		return cartService.findAllOrders();
	}
	
	@GetMapping("/orders/{id}")
	public OrderLine findOrderById(@PathVariable int id){
		return cartService.findOrderById(id);
	}
	
	@PostMapping("/orders")
	public OrderLine insertOrder(@RequestBody OrderLine orderObj){
		System.out.println("OrderObj: " + orderObj);
		return cartService.insertOrder(orderObj);
	}
	
	@PutMapping("/orders")
	public OrderLine updateOrder(@RequestBody OrderLine orderObj){
		OrderLine order = cartService.findOrderById(orderObj.getOrderLineId());
		return cartService.updateOrder(orderObj, order);
	}
	
	@DeleteMapping("/orders/{id}")
	public void deleteOrder(@PathVariable int id) {
		OrderLine order1 = cartService.findOrderById(id);
		OrderLine orderTemp = null;
		System.out.println(order1.getQuantitySelected());
		Cart cart = cartService.findCartById(order1.getCartObj().getCartId());
		for(OrderLine o : cart.getOrderLine()) {
			if(o.getOrderLineId() == order1.getOrderLineId()) {
				orderTemp = o;
			}
		}
		
		cart.getOrderLine().remove(orderTemp);
		order1.setCartObj(null);
		cartService.deleteOrder(order1.getOrderLineId());
	}

}
