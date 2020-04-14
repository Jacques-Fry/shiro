package com.jacques.shiro.utils;


import java.io.File;

/**
 * @author 花落泪知雨
 * @create 2019/9/3
 */
public final class pathUtils {

    /**
     * 获取jar包所在位置 WINDOWS
     *
     * @return
     */
    public String getPath() {
        String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        if (System.getProperty("os.name").contains("dows")) {
            path = path.substring(1, path.length());
        }
        if (path.contains("jar")) {
            path = path.substring(0, path.lastIndexOf("."));
            return path.substring(0, path.lastIndexOf("/"));
        }
        return path.replace("target/classes/", "");
    }

    public String getJar() {
        String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
        path = path.substring(5, path.length());
        System.out.println("jar包目录：" + path);
        String folderName = "myfolder";
        String filePath = path + folderName;
        File file = new File(filePath);
        if (file.exists() && file.isDirectory()) {
            return file.getAbsolutePath();//文件绝对路径
        } else {
            System.out.println("文件夹在jar包同目录下不存在，或者不是文件夹");
            return null;
        }
    }
}
