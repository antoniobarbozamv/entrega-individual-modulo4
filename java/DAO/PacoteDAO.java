package site.DAO;

import java.sql.*;

import site.Pacote;
import site.factory.ConnectionFactory;

import java.util.*;

public class PacoteDAO {

	/*
	 * CRUD:
	 * C: Create
	 * R: Read
	 * U: Update
	 * D: Delete
	 */
	
	public void save(Pacote pacote) {
		
		String sql = "INSERT INTO pacotes(id_pacote, nome_pacote, descricao, pais, valor_pacote) VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Criamos uma PreparedStatement, para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionar os valores que são esperados pela query
			pstm.setLong(1, pacote.getId_pacote());
			pstm.setString(2, pacote.getNome_pacote());
			pstm.setString(3, pacote.getDescricao());
			pstm.setString(4, pacote.getPais());
			pstm.setDouble(5, pacote.getValor_pacote());
			
			//Executar a query
			pstm.execute();
			
			System.out.println("Pacote salvo com sucesso!");
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

	public void update(Pacote pacote) {
		
		String sql = "UPDATE pacotes SET nome_pacote = ?, descricao = ?, pais = ?, valor_pacote = ? "+
		"WHERE id_pacote = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Criar a classe para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores para atualizar
			pstm.setString(1, pacote.getNome_pacote());
			pstm.setString(2, pacote.getDescricao());
			pstm.setString(3, pacote.getPais());
			pstm.setDouble(4, pacote.getValor_pacote());
			
			//Qual o ID do registro que deseja atualizar?
			pstm.setLong(5, pacote.getId_pacote());
			
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
	
	public void deleteByID(int id_pacote) {
		
		String sql = "DELETE FROM pacotes WHERE id_pacote = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id_pacote);
			
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
	public List<Pacote> getPacotes(){
		String sql = "SELECT * FROM pacotes";
		
		List<Pacote> pacotes = new ArrayList<Pacote>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Pacote pacote = new Pacote();
				
				//Recuperar o id_pacote
				pacote.setId_pacote(rset.getInt("id_pacote"));
				//Recuperar o nome_pacote
				pacote.setNome_pacote(rset.getString("nome_pacote"));
				//Recuperar a descricao
				pacote.setDescricao(rset.getString("descricao"));
				//Recuperar o pais
				pacote.setPais(rset.getString("pais"));
				//Recuperar o valor_pacote
				pacote.setValor_pacote(rset.getDouble("valor_pacote"));
				
				pacotes.add(pacote);
			
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
			
			return pacotes;
	}
}