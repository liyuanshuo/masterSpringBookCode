package liyuanshuo.fileResources;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

/**
 * Author : liyuanshuo
 * Date : 2018/12/18 1:22
 * Description :  add description here
 * Version 1.0
 */
public class EncodedResourceExample {
    public static void main(String[] args) throws IOException {
        Resource resource = new ClassPathResource("encodedfile.txt");
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        String context = FileCopyUtils.copyToString(encodedResource.getReader());
        System.out.println(context);
    }
}
