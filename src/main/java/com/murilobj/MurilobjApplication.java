package com.murilobj;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.murilobj.domain.Address;
import com.murilobj.domain.BankSlipPayment;
import com.murilobj.domain.CardPayment;
import com.murilobj.domain.Categoria;
import com.murilobj.domain.City;
import com.murilobj.domain.Cliente;
import com.murilobj.domain.Estado;
import com.murilobj.domain.ItemPedido;
import com.murilobj.domain.Payment;
import com.murilobj.domain.Pedido;
import com.murilobj.domain.Produto;
import com.murilobj.domain.enums.StatePayment;
import com.murilobj.domain.enums.TipoCliente;
import com.murilobj.repositories.AddressRepository;
import com.murilobj.repositories.CategoriaRepository;
import com.murilobj.repositories.CityRepository;
import com.murilobj.repositories.ClienteRepository;
import com.murilobj.repositories.EstadoRepository;
import com.murilobj.repositories.ItemPedidoRepository;
import com.murilobj.repositories.PaymentRepository;
import com.murilobj.repositories.PedidoRepository;
import com.murilobj.repositories.ProdutoRepository;

@SpringBootApplication
public class MurilobjApplication implements CommandLineRunner {

	@Autowired	
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private AddressRepository addresRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(MurilobjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria ("Informática", null);
		Categoria cat2 = new Categoria ("Escritório",null );
		Categoria cat3 = new Categoria ("Bed Shower ",null );
		Categoria cat4 = new Categoria ("Electronics",null );
		Categoria cat5 = new Categoria ("Garden",null );
		Categoria cat6 = new Categoria ("Decoration",null );
		Categoria cat7 = new Categoria ("Perfum",null );
		
		Produto p1 = new Produto(null, "Computer", 2000.00);
		Produto p2 = new Produto(null, "Printer", 800.00);
		Produto p3 = new Produto(null, "Mouse", 70.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));		
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
	
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		City c1 = new City(null, "Uberlândia", est1);
		City c2 = new City(null, "São Paulo", est2);
		City c3 = new City(null, "Campinas", est2);
		
		est1.getCities().addAll(Arrays.asList(c1));
		est2.getCities().addAll(Arrays.asList(c2,c3));

		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cityRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente (null,"Mariana Benatti", "mariana@gmail.com", "63025875612", "384 almirante barroso", TipoCliente.INDIVIDUAL);
		cli1.getTelefones().addAll(Arrays.asList("921759875"));
		
		Cliente cli2 = new Cliente (null," Benatti", "mar@gmail.com", "630875612", "84 almirante barroso", TipoCliente.INDIVIDUAL);
		cli2.getTelefones().addAll(Arrays.asList("920009875"));
		
		
		Address a1 = new Address(null, "Uberlândia", "38412037","384", "Almirante Barroso", cli1, c1);
		Address a2 = new Address(null, "São Paulo", "10159877","124", "Tamilt Doi", cli2, c2);
		
		cli1.getAddress().addAll(Arrays.asList(a1,a2));
		cli2.getAddress().addAll(Arrays.asList(a1,a2));
		
	
		clienteRepository.saveAll(Arrays.asList(cli1,cli2));
		addresRepository.saveAll(Arrays.asList(a1,a2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	
		Pedido ped1 = new Pedido(null, sdf.parse("12/08/2021 00:36"), cli2, a1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2021 11:11"), cli1, a2);
		
		Payment paymnt1 = new CardPayment(null, StatePayment.RECEIVED, ped1, 3);
		ped1.setPayment(paymnt1);

		Payment paymnt2 = new BankSlipPayment(null,StatePayment.PENDING, ped2, sdf.parse("17/11/2021 01:03"), null);
		ped2.setPayment(paymnt2);

		cli1.getPedidos().addAll(Arrays.asList(ped1));
		cli2.getPedidos().addAll(Arrays.asList(ped2));
			
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		paymentRepository.saveAll(Arrays.asList(paymnt1,paymnt2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);		
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);		
		ItemPedido ip3 = new ItemPedido(ped1, p2, 100.00, 1, 800.00);		

		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
		
		
	}
}
