package View;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class view2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view2 frame = new view2();
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
	public view2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewadd viewadd = new viewadd();
				viewadd.setVisible(true);
			}
		});
		btnNewButton.setBounds(20, 50, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//viewatt viewatt = new viewatt();
				//viewatt.setVisible(true);
			}
		});
		btnAtualizar.setBounds(20, 100, 117, 25);
		contentPane.add(btnAtualizar);
		
		JButton btnNewButton_1 = new JButton("Listar");
		btnNewButton_1.setBounds(20, 150, 117, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnProcPlaca = new JButton("Proc. Placa");
		btnProcPlaca.setBounds(20, 200, 117, 25);
		contentPane.add(btnProcPlaca);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(20, 250, 117, 25);
		contentPane.add(btnDeletar);
		
		JLabel label = new JLabel("");
		label.setBounds(235, 70, 180, 142);
		contentPane.add(label);
		
	}
}
