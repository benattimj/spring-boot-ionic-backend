package com.murilobj.dto;

import java.io.Serializable;

import com.murilobj.domain.Cliente;

public class ClienteNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String email;
	private String cpf_or_cnpj;
	private Integer tipo;
	private String town;
	private String postcode;
	private String number;
	private String addressLine;
	
	private String telephone;
	private String telephone2;
	private String telephone3;
	
	private Integer cidadeId;
	
	public ClienteNewDTO() {
		
		
	}
	public ClienteNewDTO(Cliente obj) {
		name = obj.getName();
		email = obj.getEmail();
		cpf_or_cnpj = obj.getCPF_or_CNPJ();
		
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephone2() {
		return telephone2;
	}

	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}

	public String getTelephone3() {
		return telephone3;
	}

	public void setTelephone3(String telephone3) {
		this.telephone3 = telephone3;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCpf_or_cnpj() {
		return cpf_or_cnpj;
	}

	public void setCpf_or_cnpj(String cpf_or_cnpj) {
		this.cpf_or_cnpj = cpf_or_cnpj;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	
	
	
}
