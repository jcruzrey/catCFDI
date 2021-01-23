/**
 * 
 */
package com.mio.cfdi.servicio.impl;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.mio.cfdi.repositorio.ISql;
import com.mio.cfdi.servicio.IImportar;

/**
 * @author jcruzrey
 *
 */
@Service("importarBd")
public class ServicioImportarBd implements IImportar{
	
	/*
	 * posibles comandos
	 * 1.- comando-vaciar
	 * 2.- comando-insertar
	 * 
	 * posibles sqls
	 * 1.- comando-vaciar-sql
	 * 2.- comando-insertar-sql
	 * 
	 */
	
	@Autowired
	@Qualifier("mysql")
	private ISql sqlRepositorio;
	/*
	 * sql para insertar datos en tabla
	 */
	@Value("${sql.insercion}")
    private String sqlInsercion;
	
	/*
	 * sql para vaciar tabla de datos
	 */
	@Value("${sql.vaciar}")
    private String sqlVaciar;
	
	/*
	 * bandera indicadora de vaciar tabla antes de importar
	 */
	@Value("${sql.ejecutarvaciar}")
    private boolean bVaciar;
    private Map<String, Object> config;

	@Override
	public List<Map<String, Object>> cargaCatalogo(String nombreHoja, File rutaCatCfdi) {
		// TODO Auto-generated method stub
		return null;
	}

}
