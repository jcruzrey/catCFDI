# catCFDI

Servicio Rest de catalogos/Utileria de importacion hacia multiple bd/Hazelcast Cache distribuido

Tecnologias: Spring Boot, Freemarker Templates/Hazelcast/Apache poi/JDBC

Java 1.8

-De momento solo esta configurado (en application.properties) para que pueda importar y exponer via los caches y controlador solo el catalogo de c_Aduana, 
puede seguir la configuracion (en application.properties) com guia e incorporar las faltantes.

Pasos para arrancar el servicio
-Configure la ruta hacia el archivo catCFDI.xls dentro del archivo de propiedades (application.properties)
-Arranue el servicio y sus catalogos configurados estaran en cache.
-Pruebe con el url http://localhost:8080/catalogo/c_Aduana. (Se considera que el serivicio levanta en el puerto 8080)

Siguientes Pasos:
-Se planea realizar lo mismo que se hace de exponer en cache, solo que sera insertar en bd. Esto sera en la siguiente version.
-Permitir retorno de valores en XML. De momento solo lo hace JSON.


