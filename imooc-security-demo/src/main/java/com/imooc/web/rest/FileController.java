package com.imooc.web.rest;

import com.imooc.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author Shinelon
 */
@RestController
@RequestMapping("/file")
public class FileController {

    String folder = "F:\\project\\imooc-security\\imooc-security-demo\\src\\main\\java\\com\\imooc\\web\\rest";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {

        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());


        File localFile = new File(folder, System.currentTimeMillis() + ".txt");

        file.transferTo(localFile);

        return new FileInfo(localFile.getAbsolutePath());

    }

    @GetMapping("/{id}")
    public void download(HttpServletResponse resp, @PathVariable String id) throws IOException {

        try (
                InputStream in = new FileInputStream(new File(folder, id + ".txt"));
                OutputStream out = resp.getOutputStream();
        ) {
            resp.setContentType("application/x-download");
            resp.addHeader("Content-Disposition", "attachment;filename=test.txt");

            IOUtils.copy(in, out);

            out.flush();
        }
    }
}
