/**
 * 
 */
package com.mio.cfdi.controlador;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mio.cfdi.Catalogos;
import com.mio.cfdi.servicio.IImportar;

/**
 * @author jcruzrey
 *
 */
@RestController
@RequestMapping("catalogo")
public class Controlador {
	
	/**
	 * Catalogos permitidos, y se usa tambien para no procesar catalogos que no existen
	 * se configura en application.properties valor default.hojas
	 */
    @Autowired
    Catalogos catalogos;
    
    /**
     * Implementacion de manejo de cache
     */
	@Autowired
	@Qualifier("importarCache")
	IImportar importarCache;
	
	/*
	 * ruta a archivo xls catCFDI
	 */
	@Value("${default.ruta}")
    private File rutaArchivoCatCfdi;
	
	/**
	 * Peticion de tipo GET que retorna un catalogo en especificado en nombreHoja
	 * @param nombreHoja
	 * @return JSON, proximamente XML
	 */
	@GetMapping(value="/{nombreHoja}", produces = "application/json")
    public @ResponseBody List<Map<String, Object>> lista(@PathVariable String nombreHoja) {
		List<Map<String, Object>> registros = new ArrayList<Map<String, Object>>();
		boolean permitido = Arrays.asList(catalogos.Lista()) 
              .contains(nombreHoja); 
		if (permitido) registros = importarCache.cargaCatalogo(nombreHoja, rutaArchivoCatCfdi);
        return registros;
    }
	
}
