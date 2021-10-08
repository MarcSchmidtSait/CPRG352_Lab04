
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <form method="get" action="view">
        <h1>Simple Note Keeper</h1>
        <br>
        <h2>View Note</h2>
        <br>
        <p>Title: ${note.title}</p>
        <br>
        <p>Contents: </p>
        <br>
        <p>${note.contents}</p>
        <br>
          </form>
        
       <a href="note?edit">Edit</a>
      
        
        
        
    </body>
</html>
