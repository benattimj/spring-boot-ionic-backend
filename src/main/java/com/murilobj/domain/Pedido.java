package com.murilobj.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date instante;
	
	private Payment payment;
	
	private Cliente cliente;
	
	private Address DeliveryAddress;
	
	
	public Pedido() {
		}


	public Pedido(Integer id, Date instante, Payment payment, Cliente cliente, Address deliveryAddress) {
		super();
		this.id = id;
		this.instante = instante;
		this.payment = payment;
		this.cliente = cliente;
		DeliveryAddress = deliveryAddress;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getInstante() {
		return instante;
	}


	public void setInstante(Date instante) {
		this.instante = instante;
	}


	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Address getDeliveryAddress() {
		return DeliveryAddress;
	}


	public void setDeliveryAddress(Address deliveryAddress) {
		DeliveryAddress = deliveryAddress;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}


}
