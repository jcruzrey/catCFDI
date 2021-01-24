# catCFDI

catalogos (catCFDI) restfull service/Database import tool/Hazelcast Cache distribuido

Tecnologias: Spring Boot, Freemarker Templates/Hazelcast/Apache poi

Java 1.8

-De momento solo esta configurado (en application.properties) para que pueda importar y exponer via los caches y controlador solo el catalogo de c_Aduana, 
puede seguir la configuracion (en application.properties) com guia e incorporar las faltantes.

-Configure la ruta hacia el archivo catCFDI.xls dentro del archivo de propiedades (application.properties)

-Arranue el servicio y sus catalogos configurados estaran en cache.

-Se planea realizar lo mismo que se hace de exponer en cache, solo que sera insertar en bd. Esto sera en la siguiente version.

