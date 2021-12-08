package com.murilobj.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date instante;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="pedido")
	private Payment payment;
	
	
	@ManyToOne
	@JoinColumn (name="cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="Delivery_Address_id")
	private Address DeliveryAddress;
	
	
	public Pedido() {
		}


	public Pedido(Integer id, Date instante, Cliente cliente, Address deliveryAddress) {
		super();
		this.id = id;
		this.instante = instante;
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