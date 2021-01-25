/**
 * 
 */
package com.mio.cfdi.servicio.impl;

import java.io.File;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(ServicioImportarBd.class);
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
   
	@Override
	public List<Map<String, Object>> cargaCatalogo(String nombreHoja, File rutaCatCfdi) {
		// TODO Auto-generated method stub
		return null;
	}

}
