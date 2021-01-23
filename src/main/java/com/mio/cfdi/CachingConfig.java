/**
 * 
 */
package com.mio.cfdi;

import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jcruzrey
 *
 */
//@Configuration
//@EnableCaching
public class CachingConfig {
	
	@Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
        		new ConcurrentMapCache("c_Aduana"),
        		new ConcurrentMapCache("c_ClaveUnidad"),
        		new ConcurrentMapCache("c_ClaveProdServ"),
        		new ConcurrentMapCache("c_CodigoPostal_Parte_1"),
        		new ConcurrentMapCache("c_CodigoPostal_Parte_2"),
        		new ConcurrentMapCache("c_FormaPago"),
        		new ConcurrentMapCache("c_Impuesto"),
        		new ConcurrentMapCache("c_MetodoPago"),
        		new ConcurrentMapCache("c_Moneda"),
        		new ConcurrentMapCache("c_NumPedimentoAduana"),
        		new ConcurrentMapCache("c_Pais"),
        		new ConcurrentMapCache("c_PatenteAduanal"),
        		new ConcurrentMapCache("c_RegimenFiscal"),
        		new ConcurrentMapCache("c_TasaOCuota"),
        		new ConcurrentMapCache("c_TipoDeComprobante"),
        		new ConcurrentMapCache("c_TipoFactor"),
        		new ConcurrentMapCache("c_TipoRelacion"),
        		new ConcurrentMapCache("c_UsoCFDI")));
        return cacheManager;
    }
}
