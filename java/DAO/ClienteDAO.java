package site.DAO;

import java.sql.*;

import site.Cliente;
import site.factory.ConnectionFactory;

import java.util.*;

public class ClienteDAO {

	/*
	 * CRUD:
	 * C: Create
	 * R: Read
	 * U: Update
	 * D: Delete
	 */
	
	public void save(Cliente cliente) {
		
		String sql = "INSERT INTO clientes(id_cliente, nome_cliente, cpf, email, contato) VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Criamos uma PreparedStatement, para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionar os valores que são esperados pela query
			pstm.setLong(1, cliente.getId_cliente());
			pstm.setString(2, cliente.getNome_cliente());
			pstm.setString(3, cliente.getCpf());
			pstm.setString(4, cliente.getEmail());
			pstm.setString(5, cliente.getContato());
			
			//Executar a query
			pstm.execute();
			
			System.out.println("Cliente salvo com sucesso!");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			//Fechar as conexões
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					pstm.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Cliente cliente) {
		
		String sql = "UPDATE clientes SET nome_cliente = ?, cpf = ?, email = ?, contato = ? "+
		"WHERE id_cliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Criar a classe para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores para atualizar
			pstm.setString(1, cliente.getNome_cliente());
			pstm.setString(2, cliente.getCpf());
			pstm.setString(3, cliente.getEmail());
			pstm.setString(4, cliente.getContato());
			
			//Qual o ID do registro que deseja atualizar?
			pstm.setInt(5, cliente.getId_cliente());
			
			//Executar a query
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteByID(int id_cliente) {
		
		String sql = "DELETE FROM clientes WHERE id_cliente = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id_cliente);
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//READ
	public List<Cliente> getClientes(){
		String sql = "SELECT * FROM clientes";
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Cliente cliente = new Cliente();
				
				//Recuperar o id_cliente
				cliente.setId_cliente(rset.getInt("id_cliente"));
				//Recuperar o nome_cliente
				cliente.setNome_cliente(rset.getString("nome_cliente"));
				//Recuperar o cpf
				cliente.setCpf(rset.getString("cpf"));
				//Recuperar o email
				cliente.setEmail(rset.getString("email"));
				//Recuperar o contato
				cliente.setContato(rset.getString("contato"));
				
				clientes.add(cliente);
			
			}}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (rset!=null) {
						rset.close();
					}
					
					if (pstm!=null) {
						pstm.close();
					}
					
					if (conn!=null) {
						conn.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			return clientes;
	}
}

