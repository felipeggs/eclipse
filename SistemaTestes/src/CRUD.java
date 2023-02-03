import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CRUD {

	
	Connection conexao = null;
	PreparedStatement comando = null;
	
	public void InserirMatricula(String CPF, String NOME, String IDADE, String CEP, String CIDADE, String ENDERECO, String NUMERO,String BAIRRO, String SERIE, String RESPONSAVEL, String PERIODO)
	{
		try {
			conexao = ClasseConexao.Conectar();
			String sql = "INSERT INTO matricula(CPF, NOME, IDADE, CEP, CIDADE, ENDERECO, NUMERO, BAIRRO, SERIE, RESPONSAVEL, PERIODO) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			comando.setString(1,CPF);
			comando.setString(2,NOME);
			comando.setString(3,IDADE);
			comando.setString(4,CEP);
			comando.setString(5,CIDADE);
			comando.setString(6,ENDERECO);
			comando.setString(7,NUMERO);
			comando.setString(8,BAIRRO);
			comando.setString(9,SERIE);
			comando.setString(10,RESPONSAVEL);
			comando.setString(11,PERIODO);
			
			if(comando.executeUpdate()>0)
			{
				System.out.println("DADOS GRAVADOS");
				JOptionPane.showMessageDialog(null,"Matriculado");
			}
		}catch(SQLException erro)
		{
			erro.printStackTrace();
		}finally {
			
			ClasseConexao.FecharConexao(conexao);
			
			try {
				comando.close();
			}catch(SQLException erro)
			{
				erro.printStackTrace();
			}
		}
	}

	
	// Método para alterar:
	public void AlterarMatricula(String CPF, String NOME, String IDADE, String CEP, String CIDADE, String ENDERECO, String NUMERO ,String BAIRRO, String SERIE, String RESPONSAVEL, String PERIODO, int MATRICULA)
	{
		try {
			conexao = ClasseConexao.Conectar();
			String sql = "UPDATE matricula SET CPF=?, NOME=?, IDADE=?, CEP=?, CIDADE=?, ENDERECO=?, NUMERO=? ,BAIRRO=?, SERIE=?, RESPONSAVEL=?, PERIODO=? WHERE MATRICULA=?";
			

			comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			comando.setString(1,CPF);
			comando.setString(2,NOME);
			comando.setString(3,IDADE);
			comando.setString(4,CEP);
			comando.setString(5,CIDADE);
			comando.setString(6,ENDERECO);
			comando.setString(7,NUMERO);
			comando.setString(8,BAIRRO);
			comando.setString(9,SERIE);
			comando.setString(10,RESPONSAVEL);
			comando.setString(11,PERIODO);
			comando.setInt(12,MATRICULA);
			
			if(comando.executeUpdate()>0)
			{
				System.out.println("DADOS ALTERADOS");
				JOptionPane.showMessageDialog(null, "DADOS ALTERADOS");
			}
		}catch(SQLException erro)
		{
			erro.printStackTrace();
		}finally {
			ClasseConexao.FecharConexao(conexao);
			
			try {
				comando.close();
			}catch(SQLException erro)
			{
				erro.printStackTrace();
			}
		}
	}
	
	public ResultSet Selecionar(String Matricula)
	{
		Connection conexao = null;
		Statement comando = null;
		ResultSet resultado = null;
		
		try {
			conexao = ClasseConexao.Conectar();
			String sql = "SELECT * FROM matricula where MATRICULA = " + Matricula;
			comando = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultado = comando.executeQuery(sql);
			
			return resultado;
		}catch(SQLException e) {
			return null;
		}
	}
	
	public ResultSet SelecionarTodos()
	{
		Connection conexao = null;
		Statement comando = null;
		ResultSet resultado = null;
		
		try {
			conexao = ClasseConexao.Conectar();
			String sql = "SELECT * FROM matricula";
			comando = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultado = comando.executeQuery(sql);
			
			return resultado;
		}catch(SQLException e) {
			return null;
		}
	}
	
	public void ExcluirAluno(int MATRICULA)
	{
		try {
			conexao = ClasseConexao.Conectar();
			String sql = "DELETE FROM matricula WHERE MATRICULA=?";
			comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		
			comando.setInt(1,MATRICULA);
			
			if(comando.executeUpdate()>0)
			{
				System.out.println("DADOS EXCLUÍDOS");
				JOptionPane.showMessageDialog(null, "DADOS DELETADOS");
			}
		}catch(SQLException erro)
		{
			erro.printStackTrace();
		}finally {
			ClasseConexao.FecharConexao(conexao);
			
			try {
				comando.close();
			}catch(SQLException erro)
			{
				erro.printStackTrace();
			}
		}
	}
}