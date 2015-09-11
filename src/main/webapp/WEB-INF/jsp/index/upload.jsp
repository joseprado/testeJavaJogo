<%-- 
    Document   : arquivo
    Created on : 07/09/2015, 22:58:11
    Author     : jose.prado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div>
            <form action="upload" method="POST" enctype="multipart/form-data">
                  <fieldset>
                    <legend>${mensagem}</legend>
                    <input type="file" name="arquivoLog" id="arquivoLog"/>

                    <button type="submit">${submit}</button>
                </fieldset>
            </form>
        </div>
           
                
           <p><h3>Partida: ${nomejogo}</h3></p>
           <p>Inicio: ${iniciojogo}</p>
           <p>Final: ${finaljogo}</p>
           <p>Maior Assassino: ${assassino} - Matou ${assassinatos} vezes, usando preferenciamente a arma ${arma}</p>
           <p>Maior Assassinado: ${assassinado} - Morreu ${mortes} vezes</p>
           
           
    </body>
</html>
