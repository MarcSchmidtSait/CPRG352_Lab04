
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;


public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String notePath = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        BufferedReader br = new BufferedReader(new FileReader(new File(notePath)));
        String title = br.readLine();
        
        String contents = "";
        String contentLine= null;
        while ((contentLine = br.readLine()) != null){
            contents += contentLine + "\n";
        }
        
        Note note = new Note(title, contents);
        request.setAttribute("note", note);
            
        if(request.getParameter("edit") != null){
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            return;
        }
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String notePath = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter pw = new PrintWriter (new BufferedWriter(new FileWriter(notePath, false)));
        String contents = request.getParameter("contents");
        String title = request.getParameter("title");
        
        Note note = new Note(title, contents);
        
        String[] numOfLines = contents.split("\n");
        int i = 0;
        String contentDis = "";
        while ( i < numOfLines.length ){
                contentDis += numOfLines[i];
                i++;    
            }
        pw.println(note.getTitle());
        pw.println(note.getContents());
        request.setAttribute("note", note);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request,response);
        
        
        
    }


}
