package com.jacques.shiro.utils.fileUtil;

import com.github.liaochong.myexcel.core.DefaultExcelReader;
import com.jacques.shiro.handler.CommonException;
import com.jacques.shiro.utils.WebStatus;

import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/**
 * excel工具
 *
 * @author Jacques·Fry
 * @version 1.0.0
 * @since 2021/2/21 14:51
 */
public class ExcelUtils {
    /**
     * 读取excel数据
     *
     * @param inputStream excel文件流信息
     * @param sheet       读取的表 1 开始
     * @param startRow    开始读取行数 1 开始
     * @param row         读取行数 0 表示不限制读取行数
     * @param clazz       返回类型
     * @return java.util.List<T>
     * @author Jacques Fry
     * @since 2021/1/14 15:41
     */
    public static <T> List<T> readExcel(InputStream inputStream, int sheet, int startRow, int row, Class<T> clazz) {

        if (sheet < 1) {
            throw new RuntimeException("参数 sheet 不得小于1");
        }
        if (startRow < 1) {
            throw new RuntimeException("参数 startRow 不得小于1");
        }

        List<T> result = null;

        try {
            result = DefaultExcelReader.of(clazz)
                    .sheet(sheet - 1)
                    .rowFilter(cells -> cells.getRowNum() >= (startRow - 1) && (row <= 0 || cells.getRowNum() < (startRow - 1) + row))
                    .beanFilter(Objects::nonNull)
                    .read(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommonException(WebStatus.ERROR,"模板解析失败");
        }
        return result;
    }
}
