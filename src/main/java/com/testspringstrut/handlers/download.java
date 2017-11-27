package com.testspringstrut.handlers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



import org.springframework.core.io.ByteArrayResource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class download {
	
   private static final String FILE_PATH = "C://ProgramData//workspace-sts-3.8.3.RELEASE//testspringstrut//src//main//resources//test.jsp";

   @GetMapping("/hello")
   public String fileUploadForm(Model model) {
      return "test";
   }

   // Using ResponseEntity<ByteArrayResource>
   @GetMapping("/download")
   public @ResponseBody ResponseEntity<ByteArrayResource> downloadFile2() throws IOException {

      Path path = Paths.get(FILE_PATH);
      byte[] data = Files.readAllBytes(path);
      ByteArrayResource resource = new ByteArrayResource(data);

      return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION,
                  "attachment;filename=" + path.getFileName().toString())
            .contentType(MediaType.TEXT_HTML).contentLength(data.length)
            .body(resource);

}

  
}