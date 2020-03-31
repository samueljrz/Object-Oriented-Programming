package View;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewLogin {

	private JFrame frame;
	private JTextField txtLogin;
	private JLabel lblSenha;
	private JPasswordField txtSenha;
	private JLabel lblNewLabel;

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
					viewLogin window = new viewLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public viewLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbLogin = new JLabel("Login");
		lbLogin.setBounds(201, 131, 70, 15);
		frame.getContentPane().add(lbLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(139, 158, 178, 32);
		frame.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(201, 202, 70, 15);
		frame.getContentPane().add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(139, 229, 178, 32);
		frame.getContentPane().add(txtSenha);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBounds(174, 273, 117, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkLogin(txtLogin.getText(), new String(txtSenha.getPassword()))) {
					 JOptionPane.showMessageDialog(null, "Bem vindo ao sistema");
					 frame.dispose();
					 view1 view1 = new view1();
					 view1.setVisible(true);
				 }else {
					 JOptionPane.showMessageDialog(null, "Dados Invalidos", "Tente Novamente", JOptionPane.WARNING_MESSAGE);
				 }
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(155, 0, 134, 133);
		Image img = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		frame.getContentPane().add(lblNewLabel);
	}
	
	public boolean checkLogin(String login, String senha) {
		if(login.equals("samueljr") && senha.equals("123")) {
			return true;
		}
		return false;
	}
}
