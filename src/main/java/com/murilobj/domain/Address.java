package com.murilobj.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.murilobj.domain.enums.TipoCliente;


@Entity
public class Address implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String Town;
		private String postcode;
		private String number;
		private String AddressLine;
		private TipoCliente tipo;

		@ManyToOne
		@JoinColumn(name="cliente_id")
		private Cliente cliente;
		
		@ManyToOne
		@JoinColumn(name="city_id")
			private City city;
		
		public Address() {					
		}

		public Address(Integer id, String Town, String postcode, String number, String AddressLine, Cliente cliente, City city) {
			super();
			this.id = id;
			this.Town = Town;
			this.postcode = postcode;
			this.number = number;
			this.setAddressLine(AddressLine);
			this.cliente = cliente;
			this.setCity(city);
		}	

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getTown() {
			return Town;
		}

		public void setTown(String Town) {
			this.Town = Town;
		}

		public String getpostcode() {
			return postcode;
		}

		public void setpostcode(String postcode) {
			this.postcode = postcode;
		}

		public String getnumber() {
			return number;
		}

		public void setnumber(String number) {
			this.number = number;
		}


		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public City getCity() {
			return city;
		}

		public void setCity(City city) {
			this.city = city;
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
			Address other = (Address) obj;
			return Objects.equals(id, other.id);
		}

		public String getAddressLine() {
			return AddressLine;
		}

		public void setAddressLine(String addressLine) {
			AddressLine = addressLine;
		}
		
		
}
