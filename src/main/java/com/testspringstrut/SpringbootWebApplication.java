package com.testspringstrut;


import java.io.*;
import com.testspringstrut.SpringbootWebApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;



@SpringBootApplication
public class SpringbootWebApplication {

	 
	
	private int maxUploadSizeInMb = 10 * 1024 * 1024; // 10 MB
	
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(SpringbootWebApplication.class);
	    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringbootWebApplication.class, args);
       
    }

	public int getMaxUploadSizeInMb() {
		return maxUploadSizeInMb;
	}

	public void setMaxUploadSizeInMb(int maxUploadSizeInMb) {
		this.maxUploadSizeInMb = maxUploadSizeInMb;
	}
	
	public void readFile()
	{
		try{
			  
			String filePath = "C://ProgramData//workspace-sts-3.8.3.RELEASE//testspringstrut//src//main//resources//test.jsp";
			String a = "<%@ page language=\"java\" contentType=\"text/html; charset=ISO-8859-1\"pageEncoding=\"ISO-8859-1\"%>\n<%@ taglib prefix=\"x\" uri=\"http://java.sun.com/jstl/xml\" %>\n<%@ taglib prefix=\"fmt\" uri=\"http://java.sun.com/jstl/fmt\" %>\n<%@ taglib prefix=\"sql\" uri=\"http://java.sun.com/jstl/sql\" %>";
			String b = "<%@ taglib prefix=\"c\" uri=\"http://java.sun.com/jstl/core\" %>";


			File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "", oldtext = "";
            while((line = reader.readLine()) != null)
                {
                oldtext += line + "\r\n";
            }
            reader.close();
            
            FileWriter writer = new FileWriter(filePath);
            String newtext = oldtext.replace(a, b).replace("Hello World","<c:out value=\"${message}\"></c:out>");
             
            writer.write(newtext);
           
            writer.close();
           }
		catch (Exception e) {
			  System.err.println("Error: " + e.getMessage());
			                }
		
	
		
	}
	
}