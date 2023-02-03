import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class Alterar {
	CRUD executar = new CRUD();

	public JFrame frmAlterar;
	JTextField text_cpf;
	JTextField text_nome;
	JTextField text_idade;
	JTextField text_cep;
	JTextField text_cidade;
	JTextField text_endereco;
	JTextField text_numero;
	JTextField text_bairro;
	JTextField text_serie;
	JTextField text_matricula;
	
	
	
	
	JTable tabelaListagem;
	JScrollPane scrollPane;
	JButton btnAlterar;
	private JLabel lblIdade;
	private JLabel lblCep;
	private JLabel lblCidade;
	private JTextField text_responsavel;
	private JTextField text_periodo;
	
	private JLabel lblN;
	
	public void AlterarMatricula()
	{
	// Vamos listar e jogar dentro da tabela_listagem:
	executar.AlterarMatricula(text_cpf.getText(), text_nome.getText(), text_idade.getText(), text_cep.getText(), text_cidade.getText(), text_endereco.getText(), text_numero.getText(), text_bairro.getText(), text_serie.getText(), text_responsavel.getText(), text_periodo.getText() ,Integer.parseInt(text_matricula.getText()));
	
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alterar window = new Alterar();
					window.frmAlterar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
public void Selecionando() {
		CRUD executar = new CRUD();	
		ResultSet resultado = executar.Selecionar(text_matricula.getText());
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


private void buscarCep() {
	String logradouro="";
	String tipoLogradouro="";
	String resultado=null;
	String cep=text_cep.getText();
	try {
		URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
		SAXReader xml = new SAXReader();
		Document documento = xml.read(url);
		Element root = documento.getRootElement();
		for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
			Element element = it.next();
			if(element.getQualifiedName().equals("cidade")) {
				text_cidade.setText(element.getText());					
			}
			if(element.getQualifiedName().equals("bairro")) {
				text_bairro.setText(element.getText());					
			}				
			if(element.getQualifiedName().equals("tipo_logradouro")) {
				tipoLogradouro = element.getText();				
			}
			if(element.getQualifiedName().equals("logradouro")) {
				logradouro = element.getText();				
			}
			if (element.getQualifiedName().equals("resultado")) {
				resultado = element.getText();
				if(resultado.equals("1")) {
					
				}else {
					JOptionPane.showMessageDialog(null, "CEP não encontrado");
				}
			}
			//Setar o campo endereço
			text_endereco.setText(tipoLogradouro + " " + logradouro);
							
		}
	}catch(Exception e) {
		System.out.println(e);
	}
}



	/**
	 * Create the application.
	 */
	public Alterar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlterar = new JFrame();
		frmAlterar.getContentPane().setBackground(new Color(192, 192, 192));
		frmAlterar.setBounds(100, 100, 1239, 495);
		frmAlterar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAlterar.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 56, 45, 14);
		frmAlterar.getContentPane().add(lblNewLabel);
		
		JLabel lblMatricula = new JLabel("MATRICULA:");
		lblMatricula.setFont(new Font("Verdana", Font.BOLD, 14));
		lblMatricula.setBounds(70, 12, 110, 14);
		frmAlterar.getContentPane().add(lblMatricula);
		
		text_matricula = new JTextField();
		text_matricula.setColumns(10);
		text_matricula.setBounds(190, 11, 193, 20);
		frmAlterar.getContentPane().add(text_matricula);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNome.setBounds(10, 81, 58, 14);
		frmAlterar.getContentPane().add(lblNome);
		
		JLabel lblEndereo = new JLabel("ENDERECO:");
		lblEndereo.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEndereo.setBounds(10, 186, 94, 14);
		frmAlterar.getContentPane().add(lblEndereo);
		
		JLabel lblBairro = new JLabel("BAIRRO:");
		lblBairro.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBairro.setBounds(10, 215, 94, 14);
		frmAlterar.getContentPane().add(lblBairro);
		
		JLabel lblEndereo_2 = new JLabel("SÉRIE:");
		lblEndereo_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEndereo_2.setBounds(10, 240, 94, 14);
		frmAlterar.getContentPane().add(lblEndereo_2);
		
		JLabel lblEndereo_3 = new JLabel("RESPONSÁVEL:");
		lblEndereo_3.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEndereo_3.setBounds(10, 265, 128, 14);
		frmAlterar.getContentPane().add(lblEndereo_3);
		
		JLabel lblEndereo_2_2 = new JLabel("PERÍODO:");
		lblEndereo_2_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEndereo_2_2.setBounds(10, 291, 94, 14);
		frmAlterar.getContentPane().add(lblEndereo_2_2);
		
		text_endereco = new JTextField();
		text_endereco.setBounds(138, 185, 175, 20);
		frmAlterar.getContentPane().add(text_endereco);
		text_endereco.setColumns(10);
		
		text_bairro = new JTextField();
		text_bairro.setColumns(10);
		text_bairro.setBounds(138, 214, 175, 20);
		frmAlterar.getContentPane().add(text_bairro);
		
		text_serie = new JTextField();
		text_serie.setColumns(10);
		text_serie.setBounds(138, 239, 175, 20);
		frmAlterar.getContentPane().add(text_serie);
		
		text_cidade = new JTextField();
		text_cidade.setColumns(10);
		text_cidade.setBounds(138, 160, 175, 20);
		frmAlterar.getContentPane().add(text_cidade);
		
		text_cep = new JTextField();
		text_cep.setColumns(10);
		text_cep.setBounds(138, 135, 175, 20);
		frmAlterar.getContentPane().add(text_cep);
		
		text_idade = new JTextField();
		text_idade.setColumns(10);
		text_idade.setBounds(138, 110, 175, 20);
		frmAlterar.getContentPane().add(text_idade);
		
		text_nome = new JTextField();
		text_nome.setColumns(10);
		text_nome.setBounds(138, 80, 175, 20);
		frmAlterar.getContentPane().add(text_nome);
		
		text_cpf = new JTextField();
		text_cpf.setColumns(10);
		text_cpf.setBounds(138, 55, 175, 20);
		frmAlterar.getContentPane().add(text_cpf);
		
		JButton btn_procurar = new JButton("");
		btn_procurar.setIcon(new ImageIcon(Alterar.class.getResource("/IMAGENS/PROCURAR_resized.png")));
		btn_procurar.setBackground(new Color(255, 255, 255));
		btn_procurar.setForeground(new Color(0, 0, 0));
		btn_procurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Selecionando();
			}
		});
		btn_procurar.setBounds(382, 11, 25, 20);
		frmAlterar.getContentPane().add(btn_procurar);
		
		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setBounds(407, 57, 806, 389);
		frmAlterar.getContentPane().add(scrollPane);
		
		tabelaListagem = new JTable();
		tabelaListagem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int linha = tabelaListagem.getSelectedRow();
				text_cpf.setText(tabelaListagem.getModel().getValueAt(linha, 0).toString());
				text_nome.setText(tabelaListagem.getModel().getValueAt(linha, 1).toString());
				text_idade.setText(tabelaListagem.getModel().getValueAt(linha, 2).toString());
				text_cep.setText(tabelaListagem.getModel().getValueAt(linha, 3).toString());
				text_cidade.setText(tabelaListagem.getModel().getValueAt(linha, 4).toString());
				text_endereco.setText(tabelaListagem.getModel().getValueAt(linha, 5).toString());
				text_numero.setText(tabelaListagem.getModel().getValueAt(linha, 6).toString());
				text_bairro.setText(tabelaListagem.getModel().getValueAt(linha, 7).toString());
				text_serie.setText(tabelaListagem.getModel().getValueAt(linha, 8).toString());
				text_responsavel.setText(tabelaListagem.getModel().getValueAt(linha, 9).toString());
				text_periodo.setText(tabelaListagem.getModel().getValueAt(linha, 10).toString());
				text_matricula.setText(tabelaListagem.getModel().getValueAt(linha, 11).toString());
			}
		});
		scrollPane.setViewportView(tabelaListagem);
		
		btnAlterar = new JButton("ALTERAR");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarMatricula();
			}
		});
		btnAlterar.setBounds(10, 357, 89, 23);
		frmAlterar.getContentPane().add(btnAlterar);
		
		lblIdade = new JLabel("IDADE:");
		lblIdade.setFont(new Font("Verdana", Font.BOLD, 14));
		lblIdade.setBounds(10, 111, 58, 14);
		frmAlterar.getContentPane().add(lblIdade);
		
		lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCep.setBounds(10, 136, 58, 14);
		frmAlterar.getContentPane().add(lblCep);
		
		lblCidade = new JLabel("CIDADE:");
		lblCidade.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCidade.setBounds(10, 161, 89, 14);
		frmAlterar.getContentPane().add(lblCidade);
		
		text_responsavel = new JTextField();
		text_responsavel.setColumns(10);
		text_responsavel.setBounds(138, 264, 175, 20);
		frmAlterar.getContentPane().add(text_responsavel);
		
		text_periodo = new JTextField();
		text_periodo.setColumns(10);
		text_periodo.setBounds(138, 290, 175, 20);
		frmAlterar.getContentPane().add(text_periodo);
		
		text_numero = new JTextField();
		text_numero.setColumns(10);
		text_numero.setBounds(338, 185, 45, 20);
		frmAlterar.getContentPane().add(text_numero);
		
		lblN = new JLabel("Nº");
		lblN.setFont(new Font("Verdana", Font.BOLD, 14));
		lblN.setBounds(316, 186, 25, 14);
		frmAlterar.getContentPane().add(lblN);
		
		JCheckBox chckbxSelecionrTodos = new JCheckBox("Selecionar todos");
		chckbxSelecionrTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					SelecionandoTodos();
				
				
			}
		});
		chckbxSelecionrTodos.setBounds(416, 10, 120, 23);
		frmAlterar.getContentPane().add(chckbxSelecionrTodos);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCep();
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\felip\\Downloads\\PROCURAR_resized.png"));
		btnNewButton.setBounds(316, 134, 25, 23);
		frmAlterar.getContentPane().add(btnNewButton);
		
		RestrictedTextField validar = new RestrictedTextField(text_cpf);
		validar.setOnlyNums(true);
		validar.setLimit(11);
		
		RestrictedTextField validar1 = new RestrictedTextField(text_cep);
		validar1.setOnlyNums(true);
		validar1.setLimit(8);
		
		RestrictedTextField validar2 = new RestrictedTextField(text_matricula);
		validar2.setOnlyNums(true);
		validar2.setLimit(9);
		
	}
}
