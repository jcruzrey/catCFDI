/**
 * 
 */
package com.mio.cfdi.repositorio;

import java.sql.SQLException;
import java.util.Map;

/**
 * @author jcruzrey
 *
 */
public interface ISql {
	int ejecutar(Map<String, Object> valores) throws SQLException;
}
