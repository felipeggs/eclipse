import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;

public class Menu {

	private JFrame frmMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.setFont(new Font("Verdana", Font.BOLD, 12));
		frmMenu.setBackground(new Color(255, 255, 255));
		frmMenu.getContentPane().setBackground(new Color(204, 204, 204));
		frmMenu.setTitle("Menu");
		frmMenu.setBounds(100, 100, 300, 300);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escolha uma opção");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel.setBounds(72, 11, 133, 29);
		frmMenu.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Matricular");
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(153, 153, 153));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Matricula j2 = new Matricula();
				j2.frmMatricula.setVisible(true);
			}
		});
		btnNewButton.setBounds(72, 59, 116, 29);
		frmMenu.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1_1 = new JButton("Alterar");
		btnNewButton_1_1.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton_1_1.setBackground(new Color(153, 153, 153));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Alterar j3 = new Alterar();
				j3.frmAlterar.setVisible(true);	
			}
		});
		btnNewButton_1_1.setBounds(72, 99, 116, 29);
		frmMenu.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Excluir");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					Excluir j4 = new Excluir();
					j4.frameExcluir.setVisible(true);	
			}
		});
		btnNewButton_1_2.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton_1_2.setBackground(new Color(153, 153, 153));
		btnNewButton_1_2.setBounds(72, 139, 116, 29);
		frmMenu.getContentPane().add(btnNewButton_1_2);
		
	}
}