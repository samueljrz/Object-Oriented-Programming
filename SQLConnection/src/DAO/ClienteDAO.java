package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Class.Cliente;
import Conexion.Conexion;
public class ClienteDAO {

	public void save(Cliente cliente) throws ClassNotFoundException {
        String sqlc = "INSERT INTO cliente (nome, cpf, cnh, endereco) VALUES (?, ?, ?, ?)";
        
        try (Connection con = Conexion.getConnection();
        		PreparedStatement ps = con.prepareStatement(sqlc)) {
           
        	ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getCnh());
            ps.setString(4, cliente.getEndereco());
            ps.executeUpdate();
            System.out.println("Registro inserido com sucesso");
            Conexion.close(con, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(Cliente cliente) throws ClassNotFoundException {
        if (cliente == null || cliente.getCpf() == null) {
            System.out.println("Não foi possivel excluir o registro");
            return;
        }
        String sqlc = "DELETE FROM cliente WHERE cpf = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlc)) {
          
        	ps.setString(1, cliente.getCpf());
            ps.executeUpdate();
            System.out.println("Registro excluido com sucesso");
            Conexion.close(con, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public  void update(Cliente cliente) throws ClassNotFoundException {
        if (cliente == null || cliente.getCpf() == null) {
            System.out.println("Não foi possivel atualizar o registro");
            return;
        }
        String sqlc = "UPDATE cliente SET nome = ?, cpf = ?, cnh = ?, endereco = ? WHERE cpf = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlc)) {
        	
        	ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getCnh());
			ps.setString(4, cliente.getEndereco());
			ps.setString(5, cliente.getCpf());
            ps.executeUpdate();
            System.out.println("Registro atualizado com sucesso");
            Conexion.close(con, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int selectOne(Cliente cliente) throws ClassNotFoundException {
    	String sqlc = "SELECT idcliente FROM cliente WHERE (nome = ? and cpf = ? and cnh = ?)";
    	int res = 0;
    	try (Connection con = Conexion.getConnection();
	             PreparedStatement ps = con.prepareStatement(sqlc)) {
	        	
				ps.setString(1, cliente.getNome());
				ps.setString(2, cliente.getCpf());
				ps.setString(3, cliente.getCnh());
				
				ResultSet rs = ps.executeQuery();
	            
				if(rs.next()) {
	            	res = rs.getInt("idcliente");
	            }
				Conexion.close(con, ps, rs);
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
    	return res;
    }
    
    public List<Cliente> selectAll() throws ClassNotFoundException {
        String sqlc = "SELECT nome, cpf, cnh, endereco FROM cliente";
        List<Cliente> clienteList = new ArrayList<>();
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlc);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                clienteList.add(new Cliente(rs.getString("nome"), rs.getString("cpf"), rs.getString("cnh"), rs.getString("endereco")));
            }
            Conexion.close(con, ps, rs);
            return clienteList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Cliente> searchByCpf(String cpf) throws ClassNotFoundException {
        String sqlc = "SELECT nome, cpf, cnh, endereco FROM cliente WHERE cpf = ?";
        List<Cliente> clienteList = new ArrayList<>();
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlc)) {
        	
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	clienteList.add(new Cliente(rs.getString("nome"), rs.getString("cpf"), rs.getString("cnh"), rs.getString("endereco")));
            }
            Conexion.close(con, ps, rs);
            return clienteList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Cliente searchById(int id) throws ClassNotFoundException {
        String sqlc = "SELECT nome, cpf, cnh, endereco FROM cliente WHERE idcliente = ?";
        Cliente cliente = new Cliente();
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlc)) {
        	
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
            	cliente = (new Cliente(rs.getString("nome"), rs.getString("cpf"), rs.getString("cnh"), rs.getString("endereco")));
            }
            Conexion.close(con, ps, rs);
            return cliente;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
