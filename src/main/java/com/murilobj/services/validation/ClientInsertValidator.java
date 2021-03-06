package com.murilobj.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.murilobj.domain.Cliente;
import com.murilobj.domain.enums.TipoCliente;
import com.murilobj.dto.ClienteNewDTO;
import com.murilobj.repositories.ClienteRepository;
import com.murilobj.resources.exception.FieldMessage;
import com.murilobj.services.validation.utils.BR;

public class ClientInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {


		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getTipo().equals(TipoCliente.INDIVIDUAL.getCod()) && !BR.isValidCPF(objDto.getCpf_or_cnpj())){
		list.add(new FieldMessage("cpf_or_cnpj", "CPF invalid"));
		}
		
		if (objDto.getTipo().equals(TipoCliente.LEGALENTITY.getCod()) && !BR.isValidCNPJ(objDto.getCpf_or_cnpj())){
			list.add(new FieldMessage("cpf_or_cnpj", "CNPJ invalid"));
			}	

		
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if (aux != null ) {
			list.add(new FieldMessage("email", "Existing email"));
		}
		
		// inclua os testes aqui, inserindo erros na lista

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldNameString()).addConstraintViolation();
		}
		return list.isEmpty();
	}

}