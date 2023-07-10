package com.domain.Cart;

import java.util.Set;

import com.domain.OrderLine.OrderLine;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "cart")
// This is for fixing the error "Cannot call sendError() after the response has been committed" caused by infinite loop for bidirectional mapping
// everything up until property is consistent, and property is = to id property in class (needs to match id in class name not table, so private int cartId)
// put it over every entity with bidirectional mapping
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cartId")
public class Cart {

	// Data Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private int cartId;
	@Column(name = "consumer_id")
	private int consumerId;

	// one cart can belong to many orders
	@OneToMany(mappedBy = "cartObj", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<OrderLine> orderLine;


	// Getters and Setters
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}
	
	@JsonManagedReference
	public Set<OrderLine> getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(Set<OrderLine> orderLine) {
		this.orderLine = orderLine;
	}


}
