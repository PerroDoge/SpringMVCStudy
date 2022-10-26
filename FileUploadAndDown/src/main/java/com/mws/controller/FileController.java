package com.mws.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class FileController {
    private final static String FILES_SERVER = "http://27.184.162.76:8189/upload/";

    @ResponseBody
    @RequestMapping("fileUpload")
    public Map fileUpload(MultipartFile icon, HttpServletRequest req) throws IOException {
        Map<String, String> resultMap = new HashMap<>();
        String icon_name = icon.getOriginalFilename();
        String suffix = icon_name.substring(icon_name.lastIndexOf("."));
        if(icon.getSize() > 1024 * 1024 * 5) {
            resultMap.put("message", "照片大小不能大于5M捏~");
        }else if(!(suffix.equals(".jpg") || suffix.equals(".png"))) {
            resultMap.put("message", "您上传的不是图片捏，不会有人不知道只有.jpg和.png才可以正常上传吧?");
        }
        UUID uuid = UUID.randomUUID();
        String newFileName = uuid.toString().concat(suffix);
        Client client = Client.create();
        WebResource resource = client.resource(FILES_SERVER + newFileName);
        resource.put(String.class, icon.getBytes());
        resultMap.put("message", "恭喜您上传成功了捏！");
        resultMap.put("fileName", newFileName);
        resultMap.put("fileType", icon.getContentType());
        return resultMap;
    }

    @RequestMapping("download")
    public void fileDownload(String fileName, String filetype, HttpServletResponse response) throws IOException {
        System.out.println("download invoked");
        // 设置响应头
        // 告诉浏览器要将数据保存到磁盘上,不在浏览器上直接解析
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        // 告诉浏览下载的文件类型
        response.setContentType(filetype);
        // 获取一个文件的输入流
        InputStream inputStream = new URL(FILES_SERVER + fileName).openStream();
        // 获取一个指向浏览器的输出流
        ServletOutputStream outputStream = response.getOutputStream();
        // 向浏览器响应文件即可
        IOUtils.copy(inputStream, outputStream);
    }
}
