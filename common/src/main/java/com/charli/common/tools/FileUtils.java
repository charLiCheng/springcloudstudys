package com.charli.common.tools;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @Description : 
 * @Author xiaoli.cheng
 * @Date 2019/11/8 11:07
 */
public class FileUtils {

    private static final Logger log = LoggerFactory.getLogger(FileUtils.class);

    public static void downFile(HttpServletResponse response, Object obj, String fileName, String path) {
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setCharacterEncoding("utf-8");


        OutputStream os = null;
        InputStream is = null;
        InputStream in = null;
        try {
            in = obj.getClass().getClassLoader().getResourceAsStream(path);
            if (null == in) {
                log.error("文件不存在:{}", path);
            }

            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
            String content = inputStream2String(in);

            byte[] decodeByte = Base64.decodeBase64(content);
            is = new ByteArrayInputStream(decodeByte);
            os = response.getOutputStream();
            int len = 0;
            byte[] b = new byte[1024];
            while ((len = is.read(b)) > 0) {
                os.write(b, 0, len);
            }
            os.flush();
            response.flushBuffer();
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            try {
                if (null != os) {
                    os.close();
                }
            } catch (Exception e) {
                os = null;
            }
            try {
                if (null != is) {
                    is.close();
                }

            } catch (Exception e) {
                is = null;
            }
            try {
                if (null != in) {
                    in.close();
                }
            } catch (Exception e) {
                in = null;
            }
        }

    }

    public static String inputStream2String(InputStream in) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = 0;
        byte[] b = new byte[1024];
        while ((len = in.read(b, 0, b.length)) != -1) {
            baos.write(b, 0, len);
        }
        byte[] buffer = baos.toByteArray();
        //base64加密
        return Base64.encodeBase64String(buffer);
    }

}


