# catCFDI
Servicio rest con cache hazelcast hecho con Spring boot

-De momento solo esta configurado (en application.properties) para que pueda importar y exponer via los caches y controlador solo el catalogo de c_Aduana, 
puede seguir la configuracion (en application.properties) com guia e incorporar las faltantes.

-Configure la ruta hacia el archivo catCFDI.xls dentro del archivo de propiedades (application.properties)

-Arranue el servicio y sus catalogos configurados estaran en cache.

-Se planea realizar lo mismo que se hace de exponer en cache, solo que sera insertar en bd. Esto sera en la siguiente version.

