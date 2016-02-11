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
			this.conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PMS_JAVA", "postgres", "postgres");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
