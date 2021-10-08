<%-- 
    Document   : editnote
    Created on : Oct 8, 2021, 2:52:58 PM
    Author     : 854638
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        
        <form method="post" action="edit">
            <label>Title: </label>
            <input type="text" name="title" value="${note.title}">
            <br>
            <label>Contents: </label>
            <textarea type="text" name="contents" value="${note.contents}"></textarea>
            <br><br>
            <input type="submit" value="save">
        </form>
    </body>
</html>
