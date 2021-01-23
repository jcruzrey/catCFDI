/**
 * 
 */
package com.mio.cfdi.servicio;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;

/**
 * @author jcruzrey
 *
 */
public interface IImportar {
	List<Map<String, Object>> cargaCatalogo(final String nombreHoja, final File rutaCatCfdi);
}
