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
-http://localhost:8080/inicio o http://localhost:8080/ te mostraran los catalogos en cache, el nuero de registros y un boton (Logica de importar en progreso) para importar a BD.

Siguientes Pasos:
-Se planea realizar lo mismo que se hace de exponer en cache, solo que sera insertar en bd. Esto sera en la siguiente version.
-Permitir retorno de valores en XML. De momento solo lo hace JSON.

Durante la carga del contexto de la aplicacion, se podra ver el procesamiento de los catalogos como salidas en el log
.m.c.s.StartupApplicationListenerCatCfdi : Procesando carga inicial de cache con origen C:\Users\jcruzrey\Documents\workspace-personal\cfdi\src\main\resources\origen\catCFDI.xls
.m.c.s.StartupApplicationListenerCatCfdi : Procesando c_Aduana ...

Historial
25 de Enero del 2021
-Forma de importacion (De momento solo es la forma con informacion relevante de los catalogos)
-Configuracion de otro catalogo en application properties
