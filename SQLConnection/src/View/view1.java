package View;

import java.awt.EventQueue;


import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class view1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println(ex);
        } 
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view1 frame = new view1();
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
	public view1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(12, 140, 185, 159);
		Image img = new ImageIcon(this.getClass().getResource("/carro.png")).getImage();
		contentPane.setLayout(null);
		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(163, 140, 152, 117);
		Image img1 = new ImageIcon(this.getClass().getResource("/cliente.png")).getImage();
		label.setIcon(new ImageIcon(img1));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(312, 146, 136, 117);
		Image img2 = new ImageIcon(this.getClass().getResource("/registros.png")).getImage();
		label_1.setIcon(new ImageIcon(img2));
		contentPane.add(label_1);
		
		JButton btnCarros = new JButton("Carros");
		btnCarros.setBounds(22, 278, 117, 25);
		btnCarros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view2 view2 = new view2();
				view2.setVisible(true);
			}
		});
		Image img4 = new ImageIcon(this.getClass().getResource("/car.png")).getImage();
		btnCarros.setIcon(new ImageIcon(img4));
		contentPane.add(btnCarros);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setBounds(173, 278, 117, 25);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view3 view3 = new view3();
				view3.setVisible(true);
			}
		});
		Image img5 = new ImageIcon(this.getClass().getResource("/user.png")).getImage();
		btnClientes.setIcon(new ImageIcon(img5));
		contentPane.add(btnClientes);
		
		JButton btnRegistros = new JButton("Registros");
		btnRegistros.setBounds(322, 278, 117, 25);
		btnRegistros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view4 view4 = new view4();
				view4.setVisible(true);
			}
		});
		Image img6 = new ImageIcon(this.getClass().getResource("/folder_table.png")).getImage();
		btnRegistros.setIcon(new ImageIcon(img6));
		contentPane.add(btnRegistros);
		
		JLabel lblLocadoraUfc = new JLabel("Locadora UFC");
		lblLocadoraUfc.setBounds(173, 0, 117, 41);
		contentPane.add(lblLocadoraUfc);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(173, 31, 105, 80);
		Image img3 = new ImageIcon(this.getClass().getResource("/ufcq.png")).getImage();
		label_2.setIcon(new ImageIcon(img3));
		contentPane.add(label_2);
	}
}
