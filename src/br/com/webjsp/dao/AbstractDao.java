package br.com.webjsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class AbstractDao {
	protected Connection conexao = null;
	protected PreparedStatement comandoSQL = null;
	protected ResultSet resultadoSql = null;
	
	protected void configuraConexao()
	{
		try {
			Class.forName("org.postgresql.Driver");
			this.conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pms", "postgres", "9903");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
