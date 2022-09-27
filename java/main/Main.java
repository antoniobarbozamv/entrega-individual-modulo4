package site.main;

import java.util.Date;

import site.Cliente;
import site.Compra;
import site.Pacote;
import site.DAO.ClienteDAO;
import site.DAO.CompraDAO;
import site.DAO.PacoteDAO;

public class Main {

	public static void main(String[] args) {
		
		//Cliente
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setNome_cliente("Beto");
		cliente.setCpf("01345678912");
		cliente.setEmail("beto@email.com");
		cliente.setContato("(21) 1014-5689");
		
		//CREATE
		//clienteDAO.save(cliente);
		
		//Atualizar o cliente
		Cliente c1 = new Cliente();
		c1.setId_cliente(0);
		c1.setNome_cliente("Maria Gabriela");
		c1.setCpf("12345678910");
		c1.setEmail("mariag@email.com");
		c1.setContato("(21) 91234-5678");
		
		//UPDATE
		//clienteDAO.update(c1);
		
		//DELETE
		//Deletar o cliente pelo seu número de ID
		//clienteDAO.deleteByID(8);
		
		//Visualização dos registros do banco de dados TODOS
		
		for(Cliente c : clienteDAO.getClientes()) {
			 System.out.println("Cliente: "+c.getId_cliente());
		
		//Compra
		
		CompraDAO compraDAO = new CompraDAO();
		
		Compra compra = new Compra();
		compra.setData_compra(new Date());
		compra.setValor_compra(2);
		compra.setDesconto(15);
		compra.setHorario("01:14");
		
		//CREATE
		//compraDAO.save(compra);
		
		//Atualizar a compra
		Compra cp1 = new Compra();
		cp1.setId_compra(0);
		cp1.setData_compra(new Date());
		cp1.setValor_compra(2.20);
		cp1.setDesconto(15);
		cp1.setHorario("02:02");
		
		//UPDATE
		//compraDAO.update(cp1);
		
		//DELETE
		//Deletar a compra pelo seu número de ID
		//compraDAO.deleteByID(0);
		
		//Visualização dos registros do banco de dados TODOS
		
		/*
		 * for(Compra cp : compraDAO.getCompras()) {
		 * System.out.println("Compra: "+cp.getId_compra());
		 *}
		 */
		
		//Pacote
			
		PacoteDAO pacoteDAO = new PacoteDAO();
			
		Pacote pacote = new Pacote();
		pacote.setNome_pacote("Buenos Aires");
		pacote.setDescricao("Passeio no museu natural");
		pacote.setPais("Argentina");
		pacote.setValor_pacote(3000);
			
		//CREATE
		//pacoteDAO.save(pacote);
		
		//Atualizar o pacote
		Pacote p1 = new Pacote();
		p1.setId_pacote(0);
		p1.setNome_pacote("Paris");
		p1.setDescricao("Visita ao Louvre");
		p1.setPais("França");
		p1.setValor_pacote(2000);
		
		//UPDATE
		//pacoteDAO.update(p1);
			
		//DELETE
		//Deletar o pacote pelo seu número de ID
		//pacoteDAO.deleteByID(1);
			
		//Visualização dos registros do banco de dados TODOS
			
		/*
		 * for(Pacote p : pacoteDAO.getPacotes()) {
		 * System.out.println("Pacote: "+p.getId_pacote());
		 *}
		 */
			
	}
	}
}
