/**
 * 
 */
package com.mio.cfdi.repositorio;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.stereotype.Service;
/**
 * @author jcruzrey
 *
 */
@Service("mysql")
public class SqlMySql implements ISql{
	/*
	 * posibles comandos
	 * 1.- comando-vaciar
	 * 2.- comando-insertar
	 * 
	 * posibles sqls
	 * 1.- comando-vaciar-sql
	 * 2.- comando-insertar-sql
	 */
	@Override
	public int ejecutar(Map<String, Object> valores) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
