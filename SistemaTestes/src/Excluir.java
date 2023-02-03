import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JCheckBox;

public class Excluir {

	JFrame frameExcluir;
	JTextField txtmatricula;
	JTextField txtendereco;
	JTextField txtserie;
	JTextField txtnome;
	JTextField txtidade;
	JTextField txtcep;
	JTextField txtcpf;
	JTextField txtresponsavel;
	JTextField txtperiodo;
	JTextField txtbairro;
	JTextField txtnumero;
	JTextField txtcidade;
	JTable tabelaListagem;
	JScrollPane scrollPane;
	JButton btnexcluir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Excluir window = new Excluir();
					window.frameExcluir.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void Selecionando() {
		CRUD executar = new CRUD();	
		ResultSet resultado = executar.Selecionar(txtmatricula.getText());
		try {
			while(resultado.next()) {
				System.out.println(resultado.getString("CPF"));
				System.out.println(resultado.getString("NOME"));
				System.out.println(resultado.getString("IDADE"));
				System.out.println(resultado.getString("CEP"));
				System.out.println(resultado.getString("CIDADE"));
				System.out.println(resultado.getString("ENDERECO"));
				System.out.println(resultado.getString("NUMERO"));
				System.out.println(resultado.getString ("BAIRRO"));
				System.out.println(resultado.getString("SERIE"));
				System.out.println(resultado.getString("RESPONSAVEL"));
				System.out.println(resultado.getString("PERIODO"));
				System.out.println(resultado.getString("MATRICULA"));
			}
			resultado.beforeFirst();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		tabelaListagem.setModel(DbUtils.resultSetToTableModel(resultado));
	}
	
	
	public void SelecionandoTodos() {
		CRUD executar = new CRUD();	
		ResultSet resultado = executar.SelecionarTodos();
		try {
			while(resultado.next()) {
				System.out.println(resultado.getString("CPF"));
				System.out.println(resultado.getString("NOME"));
				System.out.println(resultado.getString("IDADE"));
				System.out.println(resultado.getString("CEP"));
				System.out.println(resultado.getString("CIDADE"));
				System.out.println(resultado.getString("ENDERECO"));
				System.out.println(resultado.getString("NUMERO"));
				System.out.println(resultado.getString ("BAIRRO"));
				System.out.println(resultado.getString("SERIE"));
				System.out.println(resultado.getString("RESPONSAVEL"));
				System.out.println(resultado.getString("CIDADE"));
				System.out.println(resultado.getString("PERIODO"));
				System.out.println(resultado.getString("MATRICULA"));
			}
			resultado.beforeFirst();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		tabelaListagem.setModel(DbUtils.resultSetToTableModel(resultado));
	}
	
	public void acaobotaolimpa(){
		txtcpf.setText("");
		txtnome.setText("");
		txtidade.setText("");
		txtcep.setText("");
		txtcidade.setText("");
		txtendereco.setText("");
		txtnumero.setText("");
		txtbairro.setText("");
		txtserie.setText("");
		txtresponsavel.setText("");
		txtperiodo.setText("");
		txtmatricula.setText("");
		
		
		
		
		}
	CRUD executar = new CRUD();	
	
	private JLabel lblNewLabel_1;
	private JLabel lblNmero;
	
	private JLabel lblCep;
	private JLabel lblCep_2;
	private JLabel lblCidade;
	
	public void DeletarAluno()
	
	{
	executar.ExcluirAluno(Integer.parseInt(txtmatricula.getText()));
	
	}

	/**
	 * Create the application.
	 */
	public Excluir() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameExcluir = new JFrame();
		frameExcluir.setBounds(100, 100, 1237, 519);
		frameExcluir.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(192, 192, 192));
		frameExcluir.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		txtmatricula = new JTextField();
		txtmatricula.setBounds(352, 22, 257, 23);
		desktopPane.add(txtmatricula);
		txtmatricula.setColumns(10);
		
		txtendereco = new JTextField();
		txtendereco.setColumns(10);
		txtendereco.setBounds(157, 239, 155, 20);
		desktopPane.add(txtendereco);
		
		txtserie = new JTextField();
		txtserie.setColumns(10);
		txtserie.setBounds(157, 289, 155, 20);
		desktopPane.add(txtserie);
		
		txtnome = new JTextField();
		txtnome.setColumns(10);
		txtnome.setBounds(157, 139, 155, 20);
		desktopPane.add(txtnome);
		
		txtcpf = new JTextField();
		txtcpf.setColumns(10);
		txtcpf.setBounds(157, 114, 155, 20);
		desktopPane.add(txtcpf);
		
		txtresponsavel = new JTextField();
		txtresponsavel.setColumns(10);
		txtresponsavel.setBounds(157, 314, 155, 20);
		desktopPane.add(txtresponsavel);
		
		txtperiodo = new JTextField();
		txtperiodo.setColumns(10);
		txtperiodo.setBounds(157, 339, 155, 20);
		desktopPane.add(txtperiodo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(413, 72, 798, 371);
		desktopPane.add(scrollPane);
		
		tabelaListagem = new JTable();
		tabelaListagem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

					int linha = tabelaListagem.getSelectedRow();
					txtcpf.setText(tabelaListagem.getModel().getValueAt(linha, 0).toString());
					txtnome.setText(tabelaListagem.getModel().getValueAt(linha, 1).toString());
					txtidade.setText(tabelaListagem.getModel().getValueAt(linha, 2).toString());
					txtcep.setText(tabelaListagem.getModel().getValueAt(linha, 3).toString());
					txtcidade.setText(tabelaListagem.getModel().getValueAt(linha, 4).toString());
					txtendereco.setText(tabelaListagem.getModel().getValueAt(linha, 5).toString());
					txtnumero.setText(tabelaListagem.getModel().getValueAt(linha, 6).toString());
					txtbairro.setText(tabelaListagem.getModel().getValueAt(linha, 7).toString());
					txtserie.setText(tabelaListagem.getModel().getValueAt(linha, 8).toString());
					txtresponsavel.setText(tabelaListagem.getModel().getValueAt(linha, 9).toString());
					txtperiodo.setText(tabelaListagem.getModel().getValueAt(linha, 10).toString());
					txtmatricula.setText(tabelaListagem.getModel().getValueAt(linha, 11).toString());
			}
		});
		scrollPane.setViewportView(tabelaListagem);
		
		JButton btnpesquisar = new JButton("");
		btnpesquisar.setIcon(new ImageIcon("C:\\Users\\felip\\Downloads\\PROCURAR_resized.png"));
		btnpesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Selecionando();
			}
		});
		btnpesquisar.setBounds(609, 22, 56, 23);
		desktopPane.add(btnpesquisar);
		
		btnexcluir = new JButton("EXCLUIR");
		btnexcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeletarAluno();
				acaobotaolimpa();

				
			}
		});
		btnexcluir.setBounds(200, 420, 103, 23);
		desktopPane.add(btnexcluir);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 115, 127, 14);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNome.setBounds(20, 140, 101, 14);
		desktopPane.add(lblNome);
		
		JLabel lblMatricula = new JLabel("ENDERECO:");
		lblMatricula.setFont(new Font("Verdana", Font.BOLD, 14));
		lblMatricula.setBounds(20, 240, 127, 14);
		desktopPane.add(lblMatricula);
		
		JLabel lblBairro = new JLabel("BAIRRO:");
		lblBairro.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBairro.setBounds(20, 265, 127, 14);
		desktopPane.add(lblBairro);
		
		JLabel lblSerie = new JLabel("SERIE:");
		lblSerie.setFont(new Font("Verdana", Font.BOLD, 14));
		lblSerie.setBounds(20, 290, 127, 14);
		desktopPane.add(lblSerie);
		
		JLabel lblResponsavel = new JLabel("RESPONSAVEL:");
		lblResponsavel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblResponsavel.setBounds(20, 315, 127, 14);
		desktopPane.add(lblResponsavel);
		
		JLabel lblPeriodo = new JLabel("PERIODO:");
		lblPeriodo.setFont(new Font("Verdana", Font.BOLD, 14));
		lblPeriodo.setBounds(20, 340, 127, 14);
		desktopPane.add(lblPeriodo);
		
		txtbairro = new JTextField();
		txtbairro.setColumns(10);
		txtbairro.setBounds(157, 264, 155, 20);
		desktopPane.add(txtbairro);
		
		lblNewLabel_1 = new JLabel("MATRICULA:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_1.setBounds(233, 26, 109, 19);
		desktopPane.add(lblNewLabel_1);
		
		lblNmero = new JLabel("Nº");
		lblNmero.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNmero.setBounds(317, 240, 25, 14);
		desktopPane.add(lblNmero);
		
		txtnumero = new JTextField();
		txtnumero.setColumns(10);
		txtnumero.setBounds(337, 239, 56, 20);
		desktopPane.add(txtnumero);
		
		lblCep = new JLabel("IDADE");
		lblCep.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCep.setBounds(20, 165, 101, 14);
		desktopPane.add(lblCep);
		
		txtidade = new JTextField();
		txtidade.setColumns(10);
		txtidade.setBounds(157, 164, 155, 20);
		desktopPane.add(txtidade);
		
		txtcep = new JTextField();
		txtcep.setColumns(10);
		txtcep.setBounds(157, 189, 155, 20);
		desktopPane.add(txtcep);
		
		lblCep_2 = new JLabel("CEP:");
		lblCep_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCep_2.setBounds(20, 190, 101, 14);
		desktopPane.add(lblCep_2);
		
		lblCidade = new JLabel("CIDADE:");
		lblCidade.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCidade.setBounds(20, 215, 127, 14);
		desktopPane.add(lblCidade);
		
		txtcidade = new JTextField();
		txtcidade.setColumns(10);
		txtcidade.setBounds(157, 214, 155, 20);
		desktopPane.add(txtcidade);
		
		JCheckBox chckbxSelecionrTodos = new JCheckBox("Selecionar todos");
		chckbxSelecionrTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecionandoTodos();
			}
		});
		chckbxSelecionrTodos.setBounds(671, 22, 120, 23);
		desktopPane.add(chckbxSelecionrTodos);
		
		RestrictedTextField validar = new RestrictedTextField(txtcpf);
		validar.setOnlyNums(true);
		validar.setLimit(11);
		
		RestrictedTextField validar1 = new RestrictedTextField(txtcep);
		validar1.setOnlyNums(true);
		validar1.setLimit(8);
		
		RestrictedTextField validar2 = new RestrictedTextField(txtmatricula);
		validar2.setOnlyNums(true);
		validar2.setLimit(9);
	}
}
