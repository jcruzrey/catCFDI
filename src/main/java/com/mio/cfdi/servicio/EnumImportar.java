/**
 * 
 */
package com.mio.cfdi.servicio;

/**
 * @author jcruzrey
 *
 */
public enum EnumImportar {
	/**
     * Indica que actualizar.
     */
    CACHE,
    /**
     * Afectar base de datos
     */
    BD,
    /**
     * Afecta Cache y luego Bd
     */
    AMBOS;

}
