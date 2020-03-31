package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexion.Conexion;
import Class.CupomFiscal;
import Class.Carro;
import Class.Cliente;
import DAO.CarroDAO;
import DAO.ClienteDAO;

public class CupomFiscalDAO {

	public void save(CupomFiscal cp) throws ClassNotFoundException {
        String sqlc = "INSERT INTO cupomfiscal (data, valor, qtddias, cliente, carro) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = Conexion.getConnection();
        		PreparedStatement ps = con.prepareStatement(sqlc)) {
           
        	Carro c = new Carro();
        	c = cp.getCarro();
        	CarroDAO cd = new CarroDAO();
        	int res = cd.selectOne(c);
        	Cliente cl = new Cliente();
        	cl = cp.getCliente();
        	ClienteDAO cld = new ClienteDAO();
        	int res1 = cld.selectOne(cl);
        	
        	ps.setString(1, cp.getData());
            ps.setDouble(2, cp.getValor());
            ps.setInt(3, cp.getQtdDias());
            ps.setInt(4, res1);
            ps.setInt(5, res);
            ps.executeUpdate();
            Conexion.close(con, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public int selectOne(CupomFiscal cp) throws ClassNotFoundException {
    	String sqlc = "SELECT idcupom FROM cupomfiscal WHERE (cliente = ? and carro = ? and data = ?)";
    	int res = 0;
    	try (Connection con = Conexion.getConnection();
	             PreparedStatement ps = con.prepareStatement(sqlc)) {
	        	
    			CarroDAO crd = new CarroDAO();
    			ClienteDAO cd = new ClienteDAO();
    			int res1 = cd.selectOne(cp.getCliente());
    			int res2 = crd.selectOne(cp.getCarro());
    		
				ps.setInt(1, res1);
				ps.setInt(2, res2);
				ps.setString(3, cp.getData());
				ResultSet rs = ps.executeQuery();
	            if(rs.next()) {
	            	res = rs.getInt(1);
	            }
				Conexion.close(con, ps, rs);
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
    	return res;
    }
}
