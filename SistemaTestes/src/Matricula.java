import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.JTextPane;

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
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Matricula {

	JFrame frmMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Matricula window = new Matricula();
					window.frmMatricula.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	JTextField text_cpf;
	JTextField text_nome;
	JTextField text_idade;
	JTextField text_cep;
	JTextField text_cidade;
	JTextField text_endereço;
	JTextField text_numero;
	JTextField text_bairro;
	JTextField text_serie;
	JTextField text_responsavel;
	JTextField text_periodo;
	JButton btn_matricular;
	
CRUD executar = new CRUD();
private JButton btn_procurar;


	/**
	 * Create the application.
	 */
	public Matricula() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	

	
	public void Matricular()
	{
	// Vamos listar e jogar dentro da tabela_listagem:
	executar.InserirMatricula(text_cpf.getText(), text_nome.getText(), text_idade.getText(), text_cep.getText(), text_cidade.getText(), text_endereço.getText(), text_numero.getText() ,text_bairro.getText(), text_serie.getText(), text_responsavel.getText(), text_periodo.getText());
	
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
				text_endereço.setText(tipoLogradouro + " " + logradouro);
								
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
			
	
	private void initialize() {
		frmMatricula = new JFrame();
		frmMatricula.setTitle("Matrícula");
		frmMatricula.setBounds(100, 100, 1069, 595);
		frmMatricula.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(192, 192, 192));
		frmMatricula.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCpf.setBounds(10, 26, 71, 22);
		desktopPane.add(lblCpf);
		
		JLabel lblResponsavel = new JLabel("RESPONSAVEL:");
		lblResponsavel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblResponsavel.setBounds(10, 292, 162, 22);
		desktopPane.add(lblResponsavel);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNome.setBounds(10, 59, 71, 22);
		desktopPane.add(lblNome);
		
		JLabel lblEndereo = new JLabel("ENDEREÇO:");
		lblEndereo.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEndereo.setBounds(10, 193, 127, 22);
		desktopPane.add(lblEndereo);
		
		JLabel lblBairro = new JLabel("BAIRRO:");
		lblBairro.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBairro.setBounds(10, 226, 91, 22);
		desktopPane.add(lblBairro);
		
		JLabel lblSerie = new JLabel("SERIE:");
		lblSerie.setFont(new Font("Verdana", Font.BOLD, 14));
		lblSerie.setBounds(10, 259, 71, 22);
		desktopPane.add(lblSerie);
		
		JLabel lblPerodo = new JLabel("PERÍODO:");
		lblPerodo.setFont(new Font("Verdana", Font.BOLD, 14));
		lblPerodo.setBounds(10, 323, 127, 22);
		desktopPane.add(lblPerodo);
		
		text_cpf = new JTextField();
		text_cpf.setBounds(162, 28, 164, 20);
		desktopPane.add(text_cpf);
		
		text_nome = new JTextField();
		text_nome.setBounds(162, 61, 164, 20);
		desktopPane.add(text_nome);
		
		text_endereço = new JTextField();
		text_endereço.setBounds(162, 193, 164, 20);
		desktopPane.add(text_endereço);
		
		text_bairro = new JTextField();
		text_bairro.setBounds(162, 226, 164, 20);
		desktopPane.add(text_bairro);
		
		text_serie = new JTextField();
		text_serie.setBounds(162, 259, 164, 20);
		desktopPane.add(text_serie);
		
		text_responsavel = new JTextField();
		text_responsavel.setBounds(162, 294, 164, 20);
		desktopPane.add(text_responsavel);
		
		text_periodo = new JTextField();
		text_periodo.setBounds(162, 325, 164, 20);
		desktopPane.add(text_periodo);
		
		btn_matricular = new JButton("MATRICULAR");
		btn_matricular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Matricular();
			}
		});
		btn_matricular.setBounds(10, 381, 120, 23);
		desktopPane.add(btn_matricular);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCep.setBounds(10, 127, 127, 22);
		desktopPane.add(lblCep);
		
		text_cep = new JTextField();
		text_cep.setBounds(162, 129, 164, 20);
		desktopPane.add(text_cep);
		
		JLabel lblCidade_1 = new JLabel("CIDADE:");
		lblCidade_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCidade_1.setBounds(10, 160, 127, 22);
		desktopPane.add(lblCidade_1);
		
		text_cidade = new JTextField();
		text_cidade.setBounds(162, 162, 164, 20);
		desktopPane.add(text_cidade);
		
		text_idade = new JTextField();
		text_idade.setBounds(162, 98, 164, 20);
		desktopPane.add(text_idade);
		
		JLabel lblIdade = new JLabel("Nascimento:");
		lblIdade.setFont(new Font("Verdana", Font.BOLD, 14));
		lblIdade.setBounds(10, 94, 120, 22);
		desktopPane.add(lblIdade);
		
		text_numero = new JTextField();
		text_numero.setBounds(358, 196, 52, 20);
		desktopPane.add(text_numero);
		text_numero.setColumns(10);
		
		JLabel lblN = new JLabel("Nº");
		lblN.setFont(new Font("Verdana", Font.BOLD, 14));
		lblN.setBounds(329, 193, 19, 22);
		desktopPane.add(lblN);
		
		btn_procurar = new JButton("");
		btn_procurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (text_cep.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o CEP");
					text_cep.requestFocus();
				}else {
					//Buscar cep
					buscarCep();
					
				}
			}
			
		});
		btn_procurar.setIcon(new ImageIcon("C:\\Users\\felip\\Downloads\\PROCURAR_resized.png"));
		btn_procurar.setForeground(Color.BLACK);
		btn_procurar.setBackground(Color.WHITE);
		btn_procurar.setBounds(329, 129, 25, 20);
		desktopPane.add(btn_procurar);
		
		RestrictedTextField validar = new RestrictedTextField(text_cpf);
		validar.setOnlyNums(true);
		validar.setLimit(11);
		
		RestrictedTextField validar1 = new RestrictedTextField(text_cep);
		validar1.setOnlyNums(true);
		validar1.setLimit(8);
		
		
		
	}
}
