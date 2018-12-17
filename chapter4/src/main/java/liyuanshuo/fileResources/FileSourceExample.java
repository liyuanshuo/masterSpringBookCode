package liyuanshuo.fileResources;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Author : liyuanshuo
 * Date : 2018/12/18 1:27
 * Description :  add description here
 * Version 1.0
 */
public class FileSourceExample {
    public static void main(String[] args){
        try {
            String filePath = "encodedfile.txt";
            WritableResource res1 = new PathResource(filePath);
            Resource res2 = new ClassPathResource("encodedfile.txt");

            OutputStream stream1 = res1.getOutputStream();
            stream1.write("Java是一门面向对象编程语言，不仅吸收了C++语言的各种优点，\n还摒弃了C++里难以理解的多继承、指针等概念，因此Java语言具有功能强大和简单易用两个特征。".getBytes());
            stream1.close();

            InputStream ins1 = res1.getInputStream();
            InputStream ins2 = res2.getInputStream();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int i;
            while((i=ins1.read())!=-1){
                baos.write(i);
            }
            System.out.println(baos.toString());

            System.out.println("res1:"+res1.getFilename());
            System.out.println("res2:"+res2.getFilename());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
