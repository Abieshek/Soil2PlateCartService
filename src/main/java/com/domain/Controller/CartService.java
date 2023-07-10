package com.domain.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.Cart.Cart;
import com.domain.Cart.CartRepo;
import com.domain.OrderLine.OrderLine;
import com.domain.OrderLine.OrderLineRepo;

@Service
public class CartService {
	
	@Autowired
	private CartRepo cartRepo;
	@Autowired
	private OrderLineRepo orderLineRepo;
	
	// Display all carts
	public List<Cart> findAllCarts(){
		return cartRepo.findAll();
	}
	
	public Cart findCartById(int id) {
		return cartRepo.findById(id).get();
	}
	
	public Cart findCartByConsumerId(int id) {
		return cartRepo.findByConsumerId(id);
	}
	
	// Insert cart
	public Cart insertCart(Cart cartObj) {
		return cartRepo.save(cartObj);
	}
	
	public Cart updateCart(Cart cartObj, Cart cartOld) {
		
		cartObj.setOrderLine(cartOld.getOrderLine());
		
		return cartRepo.save(cartObj);
	}
	
	// delete cart
	public void deleteCart(Cart cartObj) {
		cartRepo.delete(cartObj);
	}	
	// display all orders
	public List<OrderLine> findAllOrders(){
		return orderLineRepo.findAll();
	}
	public OrderLine findOrderById(int id) {
		return orderLineRepo.findById(id).get();
	}
	// insert order
	public OrderLine insertOrder(OrderLine order) {
		return orderLineRepo.save(order);
	}
	
	public OrderLine updateOrder(OrderLine orderObj, OrderLine order) {
		
		orderObj.setCartObj(order.getCartObj());
		
		return orderLineRepo.save(orderObj);
	}
	// delete order
	public void deleteOrder(int id) {
		orderLineRepo.deleteById(id);
	}
	

}
