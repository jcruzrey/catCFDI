/**
 * 
 */
package com.mio.cfdi.servicio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import com.mio.cfdi.Catalogos;

/**
 * @author jcruzrey
 *
 */
@Component
public class StartupApplicationListenerCatCfdi implements ApplicationListener<ContextRefreshedEvent>{

	private static final Logger logger = LoggerFactory.getLogger(StartupApplicationListenerCatCfdi.class);

	@Autowired
	@Qualifier("importarCache")
	IImportar importarCache;
	
	/*
	 * ruta a archivo xls catCFDI
	 */
	@Value("${default.ruta}")
    private File rutaArchivoCatCfdi;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		logger.info("Procesando carga inicial de cache con origen {}", rutaArchivoCatCfdi);
		List<String> hojas = new ArrayList<String>();
		try {
			Workbook workbook = WorkbookFactory.create(rutaArchivoCatCfdi);
			Iterator<Sheet> sheetIterator = workbook.sheetIterator();
			while (sheetIterator.hasNext()) {
				Sheet sheet = sheetIterator.next();
				hojas.add(sheet.getSheetName());
			}
			workbook.close();
			
			for (String hoja : hojas) {
				logger.info("Procesando {} ...", hoja);
				List<Map<String, Object>> data = importarCache.cargaCatalogo(hoja, rutaArchivoCatCfdi);
				logger.info("Se encontraron {} registros en la hoja {}", data.size(), hoja);
			}
			
			
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		logger.info("Proceso de carga inicial de cache con origen {} finalizado.", rutaArchivoCatCfdi);
	}

}
