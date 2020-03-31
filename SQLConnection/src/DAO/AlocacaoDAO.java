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
import Class.CupomFiscal;
import Conexion.Conexion;
import DAO.CarroDAO;
import DAO.ClienteDAO;
import DAO.CupomFiscalDAO;

public class AlocacaoDAO {

	public void save(Alocacao alocacao) throws ClassNotFoundException {
        String sqlc = "INSERT INTO alocacao (cliente, carro, datainicio, datafim, valor, cupomfiscal) VALUES (?, ?, ?, ?, ?, ?)";
        int res = 0;
        
        try (Connection con = Conexion.getConnection();
        		PreparedStatement ps = con.prepareStatement(sqlc)) {
           
        	Carro c = new Carro();
        	c = alocacao.getCarro();
        	CarroDAO cd = new CarroDAO();
        	res = cd.selectOne(c);
        	Cliente cl = new Cliente();
        	cl = alocacao.getCliente();
        	ClienteDAO cld = new ClienteDAO();
        	int res1 = cld.selectOne(cl);
        	CupomFiscal cp = new CupomFiscal();
        	cp = alocacao.gerarCupomFiscal();
        	CupomFiscalDAO cpd = new CupomFiscalDAO();
        	cpd.save(cp);
        	int res2 = cpd.selectOne(cp);
        	
        	ps.setInt(1, res1);
            ps.setInt(2, res);
            ps.setString(3, alocacao.getDataInicio());
            ps.setString(4, alocacao.getDataFim());
            ps.setDouble(5, alocacao.getValTotal());
            ps.setInt(6, res2);
            ps.executeUpdate();
            System.out.println("Registro inserido com sucesso");
            Conexion.close(con, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(Alocacao alocacao) throws ClassNotFoundException {
        if (alocacao == null || alocacao.getCliente() == null) {
            System.out.println("Não foi possivel excluir o registro");
            return;
        }
        String sqlc = "DELETE FROM alocacao WHERE (datainicio = ? and cliente = ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlc)) {
          
        	ClienteDAO cd = new ClienteDAO();
        	
        	ps.setString(1, alocacao.getDataInicio());
        	ps.setInt(2, cd.selectOne(alocacao.getCliente()));
            ps.executeUpdate();
            System.out.println("Registro excluido com sucesso");
            Conexion.close(con, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public  void update(Alocacao alocacao) throws ClassNotFoundException {
        if (alocacao == null || alocacao.getCliente() == null) {
            System.out.println("Não foi possivel atualizar o registro");
            return;
        }
        String sqlc = "UPDATE alocacao SET cliente = ?, carro = ?, datainicio = ?, datafim = ? WHERE cupomfiscal = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlc)) {
        	
        	CarroDAO crd = new CarroDAO();
        	ClienteDAO cld = new ClienteDAO();
        	CupomFiscalDAO cfd = new CupomFiscalDAO();
        	
        	ps.setInt(1, cld.selectOne(alocacao.getCliente()));
			ps.setInt(2, crd.selectOne(alocacao.getCarro()));
        	ps.setString(3, alocacao.getDataInicio());
			ps.setString(4, alocacao.getDataFim());
			ps.setInt(5, cfd.selectOne(alocacao.getCupomFiscal()));
			
            ps.executeUpdate();
            System.out.println("Registro atualizado com sucesso"+cld.selectOne(alocacao.getCliente())+crd.selectOne(alocacao.getCarro())+ cfd.selectOne(alocacao.getCupomFiscal()));
            Conexion.close(con, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Alocacao> selectAll() throws ClassNotFoundException {
        String sqlc = "SELECT datainicio, datafim, valor, cliente, carro, cupomfiscal FROM alocacao";
        List<Alocacao> alocacaoList = new ArrayList<>();
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlc);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                CarroDAO crd = new CarroDAO();
                ClienteDAO cld = new ClienteDAO();
            	alocacaoList.add(new Alocacao(cld.searchById(rs.getInt("cliente")), crd.searchById(rs.getInt("carro")), rs.getString("datainicio"), rs.getString("datafim")));
            }
            Conexion.close(con, ps, rs);
            return alocacaoList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Alocacao> searchByData(String data) throws ClassNotFoundException {
    	String sqlc = "SELECT datainicio, datafim, valor, cliente, carro, cupomfiscal FROM alocacao WHERE datainicio = ?";
        List<Alocacao> alocacaoList = new ArrayList<>();
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlc)) {
        	
            ps.setString(1, data);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CarroDAO crd = new CarroDAO();
                ClienteDAO cld = new ClienteDAO();
            	alocacaoList.add(new Alocacao(cld.searchById(rs.getInt("cliente")), crd.searchById(rs.getInt("carro")), rs.getString("datainicio"), rs.getString("datafim")));
            }
            Conexion.close(con, ps, rs);
            return alocacaoList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
