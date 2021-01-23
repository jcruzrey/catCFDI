/**
 * 
 */
package com.mio.cfdi.servicio.impl;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellAddress;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;

/**
 * @author jcruzrey
 *
 */
public abstract class ImportarAbstracta {

	protected boolean isAlpha(String name) {
		char[] chars = name.toCharArray();

		for (char c : chars) {
			if(!Character.isLetter(c)) {
				return false;
			}
		}

		return true;
	}

	protected String obtenerPropiedad(Map<String, Object> conf, final String nombre) {
		for (String key : conf.keySet()) {
			if (key.contains(nombre)) return conf.get(key).toString();
		}
		return null;
	}

	protected Map<String, Object> obtenerCampos(Map<String, Object> conf, final String nombre) {
		Map<String, Object> campos = new HashMap<String, Object>();
		for (String key : conf.keySet()) {
			if (key.contains(nombre) && !key.contains("version") && !key.contains("revision")) campos.put(key, conf.get(key).toString().replace(nombre, ""));
		}
		return campos;
	}
	
	protected void retornaValorDeCelda(final String ref, Sheet sheet, Map<String, Object> data, final String nombreValor) {

		if (null!=ref) {
			CellAddress cellAddress = new CellAddress(ref);
			Row row = sheet.getRow(cellAddress.getRow());
			Cell cell = row.getCell(cellAddress.getColumn());

			switch (cell.getCellTypeEnum()) {
			case BOOLEAN:
				data.put(nombreValor, (cell.getBooleanCellValue() ? "Si" : "No"));
				break;
			case STRING:
				data.put(nombreValor, cell.getRichStringCellValue().getString());
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					data.put(nombreValor, cell.getDateCellValue());
				} else {
					data.put(nombreValor, cell.getNumericCellValue());
				}
				break;
			case FORMULA:
				data.put(nombreValor, "");
				break;
			case BLANK:
				data.put(nombreValor, "");
				break;
			default:
				data.put(nombreValor, "");
			}
		}else {
			data.put(nombreValor, "");
		}
	}
	
	protected Map<String, Object> getAllKnownProperties(final String tabla, Environment env) {
		Map<String, Object> rtn = new HashMap<>();
		if (env instanceof ConfigurableEnvironment) {
			for (PropertySource<?> propertySource : ((ConfigurableEnvironment) env).getPropertySources()) {
				if (propertySource instanceof EnumerablePropertySource) {
					for (String key : ((EnumerablePropertySource) propertySource).getPropertyNames()) {
						if (key.contains(tabla))
							rtn.put(key, propertySource.getProperty(key));
					}
				}
			}
		}
		return rtn;
	}
}
