package com.charli.algorithm.customeDemo;

import java.io.File;

public class FileDemos {
    public static void main(String[] args) {
        File file = new File("D:\\第一季文档");
        int count = 0;
        getFiles(file,count);
    }
    public static void  getFiles(File file1,int count){
        if (!file1.exists()){
            return;
        }
//        里面的过滤器只是过滤当前的文件, 当然可以自己实现
//        File[] files1 = file1.listFiles(pathname -> pathname.getName().toLowerCase().endsWith(".docx"));

        File[] files = file1.listFiles();
        for (File file:files) {
            if (file.isFile()){
                if (file.getName().toLowerCase().endsWith(".avi")){
                    ++count;
                    file.delete();
//                    这个把指定文件移动到指定的文件夹里
//                    File dir = new File("D:\\lll");
//                    if (!dir.exists()){
//                        dir.mkdir();
//                    }
//                    try(FileInputStream fi =new FileInputStream(file);
//                        FileOutputStream fo = new FileOutputStream(dir + "\\" + file.getName());) {
//
//                        byte[] b  = new byte[1024];
//                        int len;
//                        while((len = fi.read(b)) != -1){
//                            fo.write(b,0,len);
//                        }
//
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                        System.out.println("=================count ="+count);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                        System.out.println("=================count ="+count);
//                    }

                }
            }else{
                getFiles(file,count);
            }
        }
        System.out.println("=================count ="+count);
    }
}
