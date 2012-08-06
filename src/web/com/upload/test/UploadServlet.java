package com.upload.test;

import java.io.*;
import java.util.*;
 
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class UploadServlet extends HttpServlet {
   
   private static final long serialVersionUID = 6443785430637937507L;

   public void init( ){
      getServletContext().getInitParameter("file-upload"); 
   }
   
   
   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       ServletOutputStream os = response.getOutputStream();
       PrintWriter writer = new PrintWriter(os);
       writer.write("Upload");
       writer.flush();
       response.setStatus(HttpServletResponse.SC_OK);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,
           IOException {
       try {
           // File file = new File("/Users/blueNmad/abc.png");
           boolean isMultiPart = ServletFileUpload.isMultipartContent(req);
           if (isMultiPart) {
               DiskFileItemFactory factory = new DiskFileItemFactory();
               // maximum size that will be stored in memory
               factory.setSizeThreshold(4 * 1024);
               // Location to save data that is larger than maxMemSize.
               String home = System.getProperty("user.home");
               factory.setRepository(new File(home));

               ServletFileUpload upload = new ServletFileUpload(factory);
               upload.setSizeMax(1024 * 1024 * 1024);

               File file;
               String filePath = home;
               PrintWriter out = res.getWriter();
               List<FileItem> fileItems = upload.parseRequest(req);
               Iterator i = fileItems.iterator();

               out.println("<html>");
               out.println("<head>");
               out.println("<title>Servlet upload</title>");
               out.println("</head>");
               out.println("<body>");
               while (i.hasNext()) {
                   FileItem fi = (FileItem) i.next();
                   if (!fi.isFormField()) {
                       // Get the uploaded file parameters
                       String fieldName = fi.getFieldName();
                       String fileName = fi.getName();
                       String contentType = fi.getContentType();
                       boolean isInMemory = fi.isInMemory();
                       long sizeInBytes = fi.getSize();
                       // Write the file
                       if (fileName.lastIndexOf("\\") >= 0) {
                           file =
                                   new File(filePath + "/"
                                           + fileName.substring(fileName.lastIndexOf("\\")));
                       }
                       else {
                           file =
                                   new File(filePath + "/"
                                           + fileName.substring(fileName.lastIndexOf("\\") + 1));
                       }
                       fi.write(file);

                       out.println("Uploaded Filename: " + fileName + "<br>");
                   }
               }
               out.println("</body>");
               out.println("</html>");
           }
       }
       catch (Exception e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
   }
}