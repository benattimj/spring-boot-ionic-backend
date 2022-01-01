package com.murilobj.services;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murilobj.domain.BankSlipPayment;
import com.murilobj.domain.ItemPedido;
import com.murilobj.domain.Pedido;
import com.murilobj.domain.enums.StatePayment;
import com.murilobj.repositories.ItemPedidoRepository;
import com.murilobj.repositories.PaymentRepository;
import com.murilobj.repositories.PedidoRepository;
import com.murilobj.repositories.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private BankSlipService bankslipservice;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private ProdutoService produtoService;

	@Transactional
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);

		return obj.orElse(null);
	}

	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPayment().setEstado(StatePayment.PENDING);
		obj.getPayment().setPedido(obj);
		
		if (obj.getPayment() instanceof BankSlipPayment) {
			BankSlipPayment bsp = (BankSlipPayment) obj.getPayment();
			bankslipservice.fillBankSlypPayment(bsp, obj.getInstante());

		}
		obj = repo.save(obj);
		paymentRepository.save(obj.getPayment());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDiscount(0.0);
			ip.setPrice(produtoService.find(ip.getProduto().getId()).getPreco());
			ip.setPedido(obj);
		}

		itemPedidoRepository.saveAll(obj.getItens());
		return obj;
	}

}
