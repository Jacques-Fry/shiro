package com.jacques.shiro.utils.fileUtil;

import com.jacques.shiro.handler.CommonException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * @author 花落泪知雨
 * @create 2019/8/20
 */
public class FileUtils {



  /**
   * 获取文件后缀
   *
   * @param fileName
   * @return
   */
  public static String getSuffix(String fileName) {
    return fileName.substring(fileName.lastIndexOf("."));
  }

  /**
   * 生成新的文件名
   *
   * @param fileOriginName 源文件名
   * @return
   */
  public static String getFileName(String fileOriginName) {
    return getUUID() + FileUtils.getSuffix(fileOriginName);
  }

  public static String getUUID() {
    return UUID.randomUUID().toString().replace("-", "");
  }

  /**
   * @param file 文件
   * @return
   */
  public static boolean upload(MultipartFile file,String filePath) {

    //使用原文件名
    // String realPath = path + "/" + fileName;

    //生成对象
    File dest = new File(filePath);

    //判断文件父目录是否存在
    if (!dest.getParentFile().exists()) {
      dest.getParentFile().mkdir();
    }

    try {
      //保存文件
      file.transferTo(dest);
      return true;
    } catch (IllegalStateException | IOException e) {
      e.printStackTrace();
      return false;
    }

  }

  public static void download(String filepath, HttpServletResponse res) {
    // 发送给客户端的数据
    OutputStream outputStream = null;
    try {
      outputStream = res.getOutputStream();
      byte[] buff = new byte[1024];
      BufferedInputStream bis = null;
      // 读取filename
      bis = new BufferedInputStream(new FileInputStream(new File(filepath)));
      int i = bis.read(buff);
      while (i != -1) {
        outputStream.write(buff, 0, buff.length);
        outputStream.flush();
        i = bis.read(buff);
      }
    } catch (IOException e) {
      e.printStackTrace();
      throw new CommonException(500, "文件下载出错");
    }
  }

}
