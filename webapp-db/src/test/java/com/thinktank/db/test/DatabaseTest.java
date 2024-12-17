package com.thinktank.db.test;

import com.thinktank.db.vo.Document;
import com.thinktank.db.vo.User;
import com.thinktank.db.factory.DaoFactory;
import com.thinktank.db.dao.proxy.DocumentDao;
import com.thinktank.db.dao.proxy.UserDao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class DatabaseTest {
    public static void main(String[] args) {
        // 测试用户操作
        testUser();
        
        // 测试文档操作
        testDocument();
        
        // 测试PDF操作
        testPdf();
    }
    
    private static void testUser() {
        try {
            UserDao userDao = DaoFactory.createUserDao();
            
            // 测试添加用户
            User user = new User();
            user.setUserId(4);
            user.setPassword("123456");
            userDao.insert(user);
            System.out.println("用户添加成功");
            
            // 测试查询用户
            User foundUser = userDao.findById(4);
            System.out.println("查询用户结果：" + (foundUser != null ? "成功" : "失败"));
            
        } catch (Exception e) {
            System.out.println("用户测试失败：" + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void testDocument() {
        try {
            DocumentDao documentDao = DaoFactory.createDocumentDao();
            
            // 测试添加文档
            Document doc = new Document();
            doc.setDocumentId(4);
            doc.setTitle("测试文档");
            doc.setContent("这是一个测试文档");
            doc.setUserId(4);
            documentDao.insert(doc);
            System.out.println("文档添加成功");
            
            // 测试查询文档
            Document foundDoc = documentDao.findById(4);
            System.out.println("查询文档结果：" + (foundDoc != null ? "成功" : "失败"));
            
        } catch (Exception e) {
            System.out.println("文档测试失败：" + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void testPdf() {
        try {
            DocumentDao documentDao = DaoFactory.createDocumentDao();
            
            // 使用绝对路径读取PDF文件
            String projectPath = System.getProperty("user.dir");
            String pdfPath = projectPath + "/ThinkTankAiReport/webapp-db/src/test/resources/test.pdf";
            File pdfFile = new File(pdfPath);
            
            if (!pdfFile.exists()) {
                System.out.println("找不到测试PDF文件，请确保文件存在于：" + pdfPath);
                return;
            }
            
            InputStream inputStream = new FileInputStream(pdfFile);
            documentDao.savePdf(2, inputStream);
            System.out.println("PDF保存成功");
            
            // 测试读取PDF
            InputStream pdfInputStream = documentDao.getPdfInputStream(2);
            if (pdfInputStream != null) {
                String outputPath = projectPath + "/downloaded_test.pdf";
                FileOutputStream outputStream = new FileOutputStream(outputPath);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = pdfInputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
                outputStream.close();
                pdfInputStream.close();
                System.out.println("PDF读取成功，已保存到：" + outputPath);
            }
            
        } catch (Exception e) {
            System.out.println("PDF测试失败：" + e.getMessage());
            e.printStackTrace();
        }
    }
} 