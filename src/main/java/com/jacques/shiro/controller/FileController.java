package com.jacques.shiro.controller;

import com.alibaba.fastjson.JSON;
import com.jacques.shiro.entity.Result;
import com.jacques.shiro.utils.WebStatus;
import com.jacques.shiro.utils.fileUtil.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Jack_YD
 * @create 2019/12/9 17:01
 */
@RestController
@RequestMapping("file")
public class FileController {

  @Value("${option.filePath}")
  private String filePath;

  @Value("${option.fileUrl}")
  private String fileUrl;

  @PostMapping("upload/one")
  public Result upload(MultipartFile file) {
    //获取文件名
    String fileName = file.getOriginalFilename();
    //生成文件路径及文件名
    String pathName = fileName.substring(fileName.lastIndexOf(".") + 1) + "/" + FileUtils.getFileName(fileName);

    if (!FileUtils.upload(file, filePath + pathName)) {
      return new Result(WebStatus.ERROR, "文件上传错误");
    }

    return new Result( "文件上传成功", JSON.parse("{\"url\":\"" + fileUrl + pathName + "\"}"));
  }

  @GetMapping("download")
  public void download(String url, HttpServletResponse res){
    FileUtils.download(filePath+url,res);

  }
}
