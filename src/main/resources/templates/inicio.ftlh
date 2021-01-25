<!DOCTYPE HTML>

<html>

    <head>

        <meta charset="UTF-8" />

        <title>${title}</title>

        <link rel="stylesheet" type="text/css" href="/css/estilos.css"/>

    </head>

    <body>

<h1>
Lista de catalogos de CFDI con el numero de registros en el cache.
</h1>
Si desea importar a BD, seleccione los catalogos a importar y presione el boton de Importar a BD:
<form action="/importar" method="post">

            <table border="1">

                <tr>

                    <th>Seleccionar</th>

                    <th>Nombre</th>

                    <th># Registros</th>                

                </tr>

                
                
                <#list catalogos?keys as key>

                    <tr>

                        <td><input type="checkbox" name="${key}" id="${key}" value="${key}"></td>

                        <td>${key}</td>

                        <td>${catalogos[key]}</td>

                    </tr>

                </#list>
            </table>          
            
                            <input type="submit" value="Importar a BD"/>
                <input type="reset" value="Reset"/>
</form>  

    </body>

</html>