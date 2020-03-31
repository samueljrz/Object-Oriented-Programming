package View;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import CRUD.CarroCRUD;

public class viewadd extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFab;
	private JTextField txtPlac;
	private JTextField txtVald;
	private JTextField txtMod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewadd frame = new viewadd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public viewadd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFabricante = new JLabel("Fabricante");
		lblFabricante.setBounds(20, 50, 100, 15);
		contentPane.add(lblFabricante);
		
		txtFab = new JTextField();
		txtFab.setBounds(20, 70, 114, 19);
		contentPane.add(txtFab);
		txtFab.setColumns(10);
		
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(20, 100, 70, 15);
		contentPane.add(lblPlaca);
		
		txtPlac = new JTextField();
		txtPlac.setBounds(20, 120, 114, 19);
		contentPane.add(txtPlac);
		txtPlac.setColumns(10);
		
		JLabel lblValorDiaria = new JLabel("Valor Diaria");
		lblValorDiaria.setBounds(20, 150, 150, 15);
		contentPane.add(lblValorDiaria);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(20, 200, 70, 15);
		contentPane.add(lblModelo);
		
		txtVald = new JTextField();
		txtVald.setBounds(20, 170, 114, 19);
		contentPane.add(txtVald);
		txtVald.setColumns(10);
		
		txtMod = new JTextField();
		txtMod.setBounds(20, 220, 114, 19);
		contentPane.add(txtMod);
		txtMod.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionar.setBounds(20, 270, 117, 25);
		contentPane.add(btnAdicionar);
		
		JLabel label = new JLabel("");
		label.setBounds(235, 70, 180, 142);
		contentPane.add(label);
	}
}
