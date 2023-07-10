package com.domain.OrderLine;

import com.domain.Cart.Cart;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "orderline")
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "orderLineId")
public class OrderLine {
	// Data Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderLine_id")
	private int orderLineId;
	@Column(name = "produce_id")
	private int produceId;
	@Column(name = "quantity_selected")
	private int quantitySelected;
	
	
	// many orders can belong to one cart
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cartObj;

	
	// Getters and Setters
	public int getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(int orderLineId) {
		this.orderLineId = orderLineId;
	}

	public int getProduceId() {
		return produceId;
	}

	public void setProduceId(int produceId) {
		this.produceId = produceId;
	}

	public int getQuantitySelected() {
		return quantitySelected;
	}

	public void setQuantitySelected(int quantitySelected) {
		this.quantitySelected = quantitySelected;
	}
	
	@JsonBackReference
	public Cart getCartObj() {
		return cartObj;
	}

	public void setCartObj(Cart cartObj) {
		this.cartObj = cartObj;
	}


}
