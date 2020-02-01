package com.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class MyClassLoader extends ClassLoader {
    private static final String fileExtension = ".class";
    private String classPath;
    public MyClassLoader(String classpath) {
        super();
        this.classPath = classpath;
    }

    public MyClassLoader(String classPath, ClassLoader classLoader) {
        super(classLoader);
        this.classPath = classPath;
    }

    // 重写父类的findClass方法,自定义加载类的方式
    protected Class findClass(String className) {
        try {
            byte[] data = null;
            String filePath = this.classPath + className + fileExtension;
            FileInputStream fis = new FileInputStream(new File(filePath));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int len = -1;
            while ((len = fis.read(buf)) != -1) {
                baos.write(buf, 0, len);
            }
            data = baos.toByteArray();
            fis.close();
            baos.close();
            return this.defineClass(className, data, 0, data.length);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return null;
    }
}
