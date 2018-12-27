package br.com.atosproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import br.com.atosproject.model.Funcionario;
import br.com.atosproject.model.Project;

/**
 * Classe DAO com metodos que acessam o banco de dados.
 * 
 * @author LUCAS-UTF8
 *
 */

public class FuncionarioDAO implements FuncionarioDAOInterface {
	BancoDados db = null;
	
	/**
	 * Metodo construtor que instancia uma conexao com o banco de dados.
	 */
	
	public FuncionarioDAO() {
		try {
			db = new BancoDados("atos_project");
		} catch (NamingException e) {
			System.out.println("Erro ao instanciar o Banco de Dados: " + e);
		}
	}
	
	/**
	 * Metodo principal que retorna uma lista de funcionarios.
	 */
	
	public List<Funcionario> listarFuncionarios() {
		List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = db.obterConexao();
			
			StringBuffer sql = new StringBuffer();

			sql.append("SELECT id_employee, name, role, salary, manager, gcm");
			sql.append(" FROM employee WHERE id_employee > 0");
			
			stmt = conn.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				
				funcionario.setIdFuncionario(rs.getLong(1));
				funcionario.setName(rs.getString(2));
				funcionario.setRole(rs.getString(3));
				funcionario.setSalary(rs.getString(4));
				funcionario.setManager(rs.getString(5));
				funcionario.setGcm(rs.getString(6));
				
				funcionario.setProjectList(listarProjetos(funcionario.getIdFuncionario()));
				funcionario.setSkills(retornaSkills(funcionario.getIdFuncionario()));
				funcionario.setCertification(retornaCertifications(funcionario.getIdFuncionario()));
				
				listaFuncionarios.add(funcionario);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro no método listarFuncionarios");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		return listaFuncionarios;
	}
	
	/**
	 * Metodo que retorna uma lista de projetos de um respectivo funcionario.
	 * @param idEmployee ID do funcionario(long).
	 */
	
	public List<Project> listarProjetos(long idEmployee) {
		List<Project> listaProjetos = new ArrayList<Project>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = db.obterConexao();
			
			String sql = "SELECT name, customer, value_of_project, dt_begin, dt_end"
					+ " FROM project"
					+ " WHERE fk_id_employee = ?";
			
			stmt = conn.prepareStatement(sql.toString());
			stmt.setLong(1, idEmployee);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Project project = new Project();
				
				project.setName(rs.getString(1));
				project.setCustomer(rs.getString(2));
				project.setValueOfProject(rs.getString(3));
				project.setDtBegin(rs.getString(4));
				project.setDtEnd(rs.getString(5));
				
				listaProjetos.add(project);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro no método listarProjetos");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		return listaProjetos;
	}
	
	/**
	 * Metodo que retorna uma lista de skills de um respectivo funcionario.
	 * @param idEmployee ID do funcionario(long).
	 */
	
	public List<String> retornaSkills(long idEmployee) {
		
		List<String> skills = new ArrayList<String>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = db.obterConexao();
			
			String sql = "SELECT skill_name"
					+ " FROM skills"
					+ " WHERE fk_id_employee = ?";
			
			stmt = conn.prepareStatement(sql.toString());
			stmt.setLong(1, idEmployee);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				skills.add(rs.getString(1));
			}
			
		} catch (SQLException e) {
			System.out.println("Erro no método retornaSkills");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		return skills;
	}
	
	/**
	 * Metodo que retorna uma lista de certifications de um respectivo funcionario.
	 * @param idEmployee ID do funcionario(long).
	 */
	
	public List<String> retornaCertifications(long idEmployee) {
		
		List<String> certifications = new ArrayList<String>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = db.obterConexao();
			
			String sql = "SELECT certification_name"
					+ " FROM certifications"
					+ " WHERE fk_id_employee = ?";
			
			stmt = conn.prepareStatement(sql.toString());
			stmt.setLong(1, idEmployee);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				certifications.add(rs.getString(1));
			}
			
		} catch (SQLException e) {
			System.out.println("Erro no método retornaCertifications");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		return certifications;
	}
}