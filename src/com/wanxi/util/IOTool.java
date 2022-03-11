package com.wanxi.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class IOTool {
    public static final String SPLIT = "\n";
    private static File note;
//    static String PATH = "C:\\Users\\25677\\IdeaProjects\\lv-shi02-11-1\\web\\note";
//    static String directory = "web";

    //  如果一个地方由多次调用当前的类里面的方法，则建议用static
    //只要由一次相同的代码，代表可能会由多次，所以这里要进行封装  提取公共部分
    public static void createNote(String path, String fileName) {
//        String aa = PATH + File.separator + directory;
        File direcotry = new File(path);
        if (!direcotry.exists()) {
            direcotry.mkdirs();
        }
        File file = new File(direcotry, fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        note = file;
    }

    public static String writeData(List<String> data) {
        if (note == null || !note.exists()) {
            return "error";
        }
        try {
            OutputStream outputStream = new FileOutputStream(note);
            for (int i = 0; i < data.size(); i++) {
                outputStream.write(data.get(i).getBytes(StandardCharsets.UTF_8));
                outputStream.write(SPLIT.getBytes(StandardCharsets.UTF_8));
            }
//            CompanyDao companyDao = new CompanyDao();
//            byte[] bytes = companyDao.logo.getBytes();
//            outputStream.write(bytes);
//            outputStream.write(split.getBytes());
//
//            outputStream.write(companyDao.phone.getBytes());
//            outputStream.write(split.getBytes());
//
//            outputStream.write(companyDao.net.getBytes());
//            outputStream.write(split.getBytes());
//
//            outputStream.write(companyDao.email.getBytes());
//            outputStream.write(split.getBytes());
//
//            outputStream.write(companyDao.address.getBytes());
//            outputStream.write(split.getBytes());
//
//            outputStream.write(companyDao.linePhone.getBytes());
//            outputStream.write(split.getBytes());
//
//            outputStream.write(companyDao.version.getBytes());
//            outputStream.write(split.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    //能写局部变量不写全局变量
    public static String readData() {
        if (note == null || !note.exists()) {
            return "error";
        }
        StringBuilder result = new StringBuilder();
        try {
//            InputStream inputStream = new FileInputStream(note);
//            int read = inputStream.read();
//            int  --char

//            System.out.println((char) read);
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(note), StandardCharsets.UTF_8));
//            Reader reader = new FileReader();
            int read = 0;
            //如果读取往后没有数据了返回一个-1

//            String 和 StringBuilder 和 StringBuffer 的区别？
//            接口和抽象类的区别？
//            重写和重载的区别？
//            ==和equals，===的区别？
            while ((read = reader.read()) != -1) {
                result.append((char) read);
            }
//            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

}
