/**
 * 
 */
package com.mio.cfdi.controlador;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mio.cfdi.Catalogos;
import com.mio.cfdi.servicio.IImportar;

/**
 * @author jcruzrey
 *
 */
@Controller
public class Inicio {
	
	/**
	 * Lo usamos para acceder a los catalogos en cache y no volver a leer desde archivo
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
	 * Catalogos permitidos, y se usa tambien para no procesar catalogos que no existen
	 * se configura en application.properties valor default.hojas
	 */
    @Autowired
    Catalogos catalogos;
    
	@GetMapping(value = {"/", "/index", "/indice", "/inicio"})
	public String index(Model model) {

		Map<String, String> catalogosMapa = new HashMap<String, String>();
		
		for (String nombreHoja : catalogos.Lista()) {
			catalogosMapa.put(nombreHoja, importarCache.cargaCatalogo(nombreHoja, rutaArchivoCatCfdi).size()+"");
		}
	   model.addAttribute("title", "prueba");
	   model.addAttribute("catalogos", catalogosMapa);

	    return "inicio";

	}
	
    @PostMapping("/importar")
    public String formPost(Model model, @RequestParam Map<String,String> allRequestParams) {
        //model.addAttribute("user", user);
    	System.out.println(allRequestParams);
        return "importar";
    }
    
}
