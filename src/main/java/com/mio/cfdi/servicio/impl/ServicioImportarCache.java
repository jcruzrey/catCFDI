/**
 * 
 */
package com.mio.cfdi.servicio.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mio.cfdi.servicio.IImportar;

/**
 * @author jcruzrey
 *
 */
@Service("importarCache")
@CacheConfig(cacheNames = "catalogos")
public class ServicioImportarCache extends ImportarAbstracta implements IImportar{

	private static final Logger logger = LoggerFactory.getLogger(ServicioImportarCache.class);
	
	@Autowired
	private Environment env;

	@Override
	@Cacheable(key="#nombreHoja")
	public List<Map<String, Object>> cargaCatalogo(final String nombreHoja, final File rutaCatCfdi) {
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		Map<String, Object> conf = getAllKnownProperties(nombreHoja,env);
		if (conf.isEmpty()) {
			logger.info("{} no cuenta con una configuracion en el arcivo de application properties.", nombreHoja);
			return data;
		}
		try {
			Workbook workbook = WorkbookFactory.create(rutaCatCfdi);
			Sheet sheet = workbook.getSheet(nombreHoja);
			data = obtenerCatalogo(conf, sheet);
			workbook.close();
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public List<Map<String, Object>> obtenerCatalogo(Map<String, Object> conf, Sheet sheet) {
		List<Map<String, Object>> registros = new ArrayList<Map<String, Object>>();
		String version = obtenerPropiedad(conf, "version");
		String revision = obtenerPropiedad(conf, "revision");
		Map<String, Object> campos = obtenerCampos(conf, sheet.getSheetName() + ".campo.");
		String inicio = obtenerPropiedad(conf, "data.inicio");
		String fin = obtenerPropiedad(conf, "data.fin");

		if (inicio!=null && fin!=null) {
			int iInicio = Integer.valueOf(inicio);
			int iFin = Integer.valueOf(fin);

			for (int x = iInicio; x < iFin; x++) {
				Map<String, Object> rtn = new HashMap<String, Object>();
				retornaValorDeCelda(version, sheet, rtn, "version");
				retornaValorDeCelda(revision, sheet, rtn, "revision");
				for (String key : campos.keySet()) {
					if (isAlpha(conf.get(key).toString())) {
						retornaValorDeCelda(conf.get(key).toString() + x, sheet, rtn, key.split("\\.")[2]);
					}else {
						retornaValorDeCelda(conf.get(key).toString(), sheet, rtn, key.split("\\.")[2]);
					}

				}
				registros.add(rtn);
			}
		}
		return registros;
	}

}
