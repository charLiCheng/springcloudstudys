package com.charli.common.tools;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description : 
 * @Author xiaoli.cheng
 * @Date 2019/11/8 11:10
 */
public class POIExcelUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(POIExcelUtil.class);
    private static DecimalFormat df = new DecimalFormat("#.################");

    public static void exportXls(HttpServletRequest request, HttpServletResponse responses, String[] header, List<Map> dataset, String templatename, String filename) {
        // 读取模板
        String path = request.getSession().getServletContext().getRealPath("");
        LOGGER.info(path);
        HSSFWorkbook workbook = null;
        HSSFSheet sheet = null;
        try (InputStream inputStream = new FileInputStream(path);
             POIFSFileSystem fileSystem = new POIFSFileSystem(inputStream)
        ) {
            workbook = new HSSFWorkbook(fileSystem);
            sheet = workbook.getSheetAt(0);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        if (sheet == null) {
            return;
        }
        // 起始行
        int rowIndex = 2;
        Row row = sheet.createRow(rowIndex++);
        // 遍历列,填充头部数据数据,如果模板中有此部分，则该部分不需要填填充
        for (int i = 0; i < header.length; i++) {
            row.createCell(i).setCellValue(header[i]);
        }
        // 遍历数据，填充入行中
        for (int i = 0; i < dataset.size(); i++) {
            row = sheet.createRow(rowIndex++);
            for (int j = 0; j < header.length; j++) {
                row.createCell(j).setCellValue(parseNull(dataset.get(i).get(header[j])));
            }
        }
        // 输出到网页
        export(responses, workbook, filename);
    }

    /**
     * 输出excel到网页
     *
     * @param response
     * @param workbook
     * @param fileName
     */
    private static void export(HttpServletResponse response, HSSFWorkbook workbook, String fileName) {
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("utf-8"), "iso8859-1"));
        } catch (UnsupportedEncodingException e) {
            LOGGER.error(e.getMessage());
        }
        response.setContentType("application/ynd.ms-excel;charset=UTF-8");
        try {
            OutputStream out = response.getOutputStream();
            workbook.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    /**
     * 输出模板
     *
     * @param request
     * @param response
     * @param fileName
     */
    public static void exportTemplate(HttpServletRequest request, HttpServletResponse response, String fileName) {
        //读取模板
        String path = request.getSession().getServletContext().getRealPath("");
        HSSFWorkbook workbook;
        try (InputStream inputStream = new FileInputStream(path);
             POIFSFileSystem fileSystem = new POIFSFileSystem(inputStream)) {
            workbook = new HSSFWorkbook(fileSystem);
            export(response, workbook, fileName);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    /**
     * 读取导入的excel文件
     *
     * @param file
     * @return
     */
    public static HSSFSheet crateSheet(MultipartFile file) {
        POIFSFileSystem fs = null;
        HSSFSheet hssfSheet = null;
        try {
            try {
                fs = new POIFSFileSystem(file.getInputStream());
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                return null;
            }
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            // 获取第一个Sheet页
            hssfSheet = wb.getSheetAt(0);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
        return hssfSheet;
    }

    /**
     * 格式化列的内容
     *
     * @param cell
     * @return
     */
    public static String formatPOI(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case Cell.CELL_TYPE_ERROR:
                return "this data is error";
            case Cell.CELL_TYPE_NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    Date date = cell.getDateCellValue();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    return dateFormat.format(date).toString();
                } else {
                    /*    cell.setCellType(Cell.CELL_TYPE_STRING);
                    return cell.getStringCellValue();*/
                    //return numberFormat.format(cell.getNumericCellValue());
                    //return String.valueOf(cell.getNumericCellValue())+"";
                    //DecimalFormat df = new DecimalFormat("#.################");
                    return df.format(cell.getNumericCellValue());
                }
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            default:
                //return "bad errors!!!";
                return null;
        }
    }

    /**
     * 将数据为null的，转换为""
     *
     * @param object
     * @return
     */
    public static String parseNull(Object object) {
        if (object == null) {
            return "";
        } else {
            return object.toString();
        }
    }

    public static Workbook getWorkBook(MultipartFile file) {
        // 获得文件名
        String fileName = file.getOriginalFilename();
        // 创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            // 获取excel文件的io流
            InputStream is = file.getInputStream();
            // 根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if (fileName.endsWith("xls") || fileName.endsWith("xlt") || fileName.endsWith("xla")) {
                // 2003
                // 避免文件后缀修改造成文件不可读，更换方式重新读取，还不行则抛出异常
                try {
                    workbook = new HSSFWorkbook(is);
                } catch (Exception e) {
                    workbook = new XSSFWorkbook(file.getInputStream());
                }
            } else if (fileName.endsWith("xlsx") || fileName.endsWith("xlsm")
                    || fileName.endsWith("xltx") || fileName.endsWith("xltm") || fileName.endsWith("xlam")) {
                // 2007
                // 避免文件后缀修改造成文件不可读，更换方式重新读取，还不行则抛出异常
                try {
                    workbook = new XSSFWorkbook(is);
                } catch (Exception e) {
                    workbook = new HSSFWorkbook(file.getInputStream());
                }
            } else if (fileName.endsWith("xlsb")) {
                // 暂无读取方案，返回null
                return null;
            }
        } catch (IOException e1) {
            LOGGER.error(e1.getMessage());
            return null;
        } catch (Exception e2) {
            LOGGER.error(e2.getMessage());
            return null;
        }
        return workbook;
    }
}
