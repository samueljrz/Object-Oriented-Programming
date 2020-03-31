package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Class.Carro;
import Conexion.Conexion;

public class CarroDAO {

	    public void save(Carro carro) throws ClassNotFoundException {
	        String sqlc = "INSERT INTO carro (fabricante, placa, valordiaria, status, modelo) VALUES (?, ?, ?, ?, ?)";
	        
	        try (Connection con = Conexion.getConnection();
	        		PreparedStatement ps = con.prepareStatement(sqlc)) {
	           
	        	ps.setString(1, carro.getFabricante());
	            ps.setString(2, carro.getPlaca());
	            ps.setDouble(3, carro.getValDiaria());
	            ps.setBoolean(4, carro.getStatus());
	            ps.setString(5, carro.getModelo());
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
	    
	    public void update(Carro carro) throws ClassNotFoundException {
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
	    
	    public int selectOne(Carro carro) throws ClassNotFoundException {
	    	String sqlc = "SELECT idcarro FROM carro WHERE (fabricante = ? and modelo = ? and placa = ? and valordiaria = ?)";
	    	int res = 0;
	    	try (Connection con = Conexion.getConnection();
		             PreparedStatement ps = con.prepareStatement(sqlc)) {
		        	
					ps.setString(1, carro.getFabricante());
					ps.setString(2, carro.getModelo());
					ps.setString(3, carro.getPlaca());
					ps.setDouble(4, carro.getValDiaria());
					
					ResultSet rs = ps.executeQuery();
					if(rs.next()) {
						res = rs.getInt("idcarro");
					}
					Conexion.close(con, ps, rs);
		        } catch (SQLException e) {
		        	e.printStackTrace();
		        }
	    	return res;
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
	    
	    public Carro searchById(int id) throws ClassNotFoundException {
	        String sqlc = "SELECT fabricante, modelo, placa, valordiaria, status FROM carro WHERE idcarro = ?";
	        Carro carro = new Carro();
	        try (Connection con = Conexion.getConnection();
	             PreparedStatement ps = con.prepareStatement(sqlc)) {
	        	
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()) {
	            	carro = (new Carro(rs.getString("fabricante"), rs.getString("modelo"), rs.getString("placa"), rs.getDouble("valordiaria"), rs.getBoolean("status")));
	            }
	            Conexion.close(con, ps, rs);
	            return carro;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

}
