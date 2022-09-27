package site.DAO;

import java.sql.*;
import java.sql.Date;

import site.Compra;
import site.factory.ConnectionFactory;

import java.util.*;

public class CompraDAO {

	/*
	 * CRUD:
	 * C: Create
	 * R: Read
	 * U: Update
	 * D: Delete
	 */
	
	public void save(Compra compra) {
		
		String sql = "INSERT INTO compras(id_compra, data_compra, valor_compra, desconto, horario) VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Criamos uma PreparedStatement, para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionar os valores que são esperados pela query
			pstm.setLong(1, compra.getId_compra());
			pstm.setDate(2, new Date(compra.getData_compra().getTime()));
			pstm.setDouble(3, compra.getValor_compra());
			pstm.setLong(4, compra.getDesconto());
			pstm.setString(5, compra.getHorario());
			
			//Executar a query
			pstm.execute();
			
			System.out.println("Compra salva com sucesso!");
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

	public void update(Compra compra) {
		
		String sql = "UPDATE compras SET data_compra = ?, valor_compra = ?, desconto = ?, horario = ? "+
		"WHERE id_compra = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Criar a classe para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores para atualizar
			pstm.setDate(1, new Date(compra.getData_compra().getTime()));
			pstm.setDouble(2, compra.getValor_compra());
			pstm.setLong(3, compra.getDesconto());
			pstm.setString(4, compra.getHorario());
			
			//Qual o ID do registro que deseja atualizar?
			pstm.setLong(5, compra.getId_compra());
			
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
	
	public void deleteByID(int id_compra) {
		
		String sql = "DELETE FROM compras WHERE id_compra = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id_compra);
			
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
	public List<Compra> getCompras(){
		String sql = "SELECT * FROM compras";
		
		List<Compra> compras = new ArrayList<Compra>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Compra compra = new Compra();
				
				//Recuperar o id_compra
				compra.setId_compra(rset.getInt("id_compra"));
				//Recuperar a data_compra
				compra.setData_compra(rset.getDate("data_compra"));
				//Recuperar o valor_compra
				compra.setValor_compra(rset.getDouble("valor_compra"));
				//Recuperar o desconto
				compra.setDesconto(rset.getInt("desconto"));
				//Recuperar o horário
				compra.setHorario(rset.getString("horario"));
				
				compras.add(compra);
			
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
			
			return compras;
	}
}

