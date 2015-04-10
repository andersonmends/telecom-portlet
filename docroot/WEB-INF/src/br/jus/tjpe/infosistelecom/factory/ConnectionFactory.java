package br.jus.tjpe.infosistelecom.factory;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionFactory {

	public static Connection getConnection() {

		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("SUCESSO");

			return DriverManager.getConnection("jdbc:mysql://192.168.251.19/db_infosistele", "sistelecom", "123456");//base dados no servidor do Recife
			//return DriverManager.getConnection("jdbc:mysql://172.28.50.4/db_infosistele_homo", "root", "(C15c*)"); // base da dados em uma VM no servidor em Garanhuns
		} catch (SQLException e) {
			System.out.println("ERRO");
			throw new RuntimeException(e);
			
		}

	}
}
