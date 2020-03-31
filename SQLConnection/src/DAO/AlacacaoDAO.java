package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Class.Alocacao;
import Class.Carro;
import Class.Cliente;
import Conexion.Conexion;
import DAO.CarroDAO;
import DAO.ClienteDAO;

public class AlacacaoDAO {

	public void save(Alocacao alocacao) throws ClassNotFoundException {
        String sqlc = "INSERT INTO alocacao (cliente, carro, datainicio, datafim, valor, cupomfiscal) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection con = Conexion.getConnection();
        		PreparedStatement ps = con.prepareStatement(sqlc)) {
           
        	Carro c = new Carro();
        	c = alocacao.getCarro();
        	CarroDAO cd = new CarroDAO();
        	int res = cd.selectOne(c);
        	Cliente cl = new Cliente();
        	cl = alocacao.getCliente();
        	ClienteDAO cld = new ClienteDAO();
        	int res1 = cld.selectOne(cl);
        	
        	ps.setInt(1, res1);
            ps.setInt(2, res);
            ps.setString(3, alocacao.getDataInicio());
            ps.setString(4, alocacao.getDataFim());
            ps.setDouble(5, alocacao.getValTotal());
            ps.executeUpdate();
            System.out.println("Registro inserido com sucesso");
            Conexion.close(con, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(Carro carro) throws ClassNotFoundException {
        if (carro == null || carro.getPlaca() == null) {
            System.out.println("Não foi possivel excluir o registro");
            return;
        }
        String sqlc = "DELETE FROM carro WHERE placa = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlc)) {
          
        	ps.setString(1, carro.getPlaca());
            ps.executeUpdate();
            System.out.println("Registro excluido com sucesso");
            Conexion.close(con, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public  void update(Carro carro) throws ClassNotFoundException {
        if (carro == null || carro.getPlaca() == null) {
            System.out.println("Não foi possivel atualizar o registro");
            return;
        }
        String sqlc = "UPDATE carro SET placa = ?, fabricante = ?, modelo = ?, valordiaria = ?, status = ? WHERE placa = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlc)) {
        	
        	ps.setString(1, carro.getPlaca());
			ps.setString(2, carro.getFabricante());
			ps.setString(3, carro.getModelo());
			ps.setDouble(4, carro.getValDiaria());
			ps.setBoolean(5, carro.getStatus());
			ps.setString(6, carro.getPlaca());
            ps.executeUpdate();
            System.out.println("Registro atualizado com sucesso");
            Conexion.close(con, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Carro> selectAll() throws ClassNotFoundException {
        String sqlc = "SELECT fabricante, modelo, placa, valordiaria, status FROM carro";
        List<Carro> carroList = new ArrayList<>();
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlc);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                carroList.add(new Carro(rs.getString("fabricante"), rs.getString("modelo"), rs.getString("placa"), rs.getDouble("valordiaria"), rs.getBoolean("status")));
            }
            Conexion.close(con, ps, rs);
            return carroList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Carro> searchByPlaca(String placa) throws ClassNotFoundException {
        String sqlc = "SELECT fabricante, modelo, placa, valordiaria, status FROM carro WHERE placa = ?";
        List<Carro> carroList = new ArrayList<>();
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlc)) {
        	
            ps.setString(1, placa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	carroList.add(new Carro(rs.getString("fabricante"), rs.getString("modelo"), rs.getString("placa"), rs.getDouble("valordiaria"), rs.getBoolean("status")));
            }
            Conexion.close(con, ps, rs);
            return carroList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
