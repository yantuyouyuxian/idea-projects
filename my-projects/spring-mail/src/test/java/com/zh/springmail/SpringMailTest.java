package com.zh.springmail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileUrlResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/25 16:07
 * @ Description
 */
@SpringBootTest
public class SpringMailTest {

    @Autowired
    JavaMailSender javaMailSender;

    /**
     * 普通邮件发送
     */
    @Test
    public void sendSimpleMail() {
        // 构建一个邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件主题
        message.setSubject("这是一封测试邮件");
        // 设置邮件发送者，这个跟application.yml中设置的要一致
        message.setFrom("2366120116@qq.com");
        // 设置邮件接收者，可以有多个接收者，中间用逗号隔开，以下类似
        // message.setTo("10*****16@qq.com","12****32*qq.com");
        message.setTo("2242757980@qq.com");
        // 设置邮件抄送人，可以有多个抄送人
//        message.setCc("12****32*qq.com");
        // 设置隐秘抄送人，可以有多个
//        message.setBcc("7******9@qq.com");
        // 设置邮件发送日期
        message.setSentDate(new Date());
        // 设置邮件的正文
        message.setText("这是测试邮件的正文");
        // 发送邮件
        javaMailSender.send(message);
    }

    /**
     * 发送带附件的邮件
     */
    @Test
    public void sendAttachFileMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        // true表示构建一个可以带附件的邮件对象
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        helper.setSubject("这是一封带附件的测试邮件");
        helper.setFrom("2366120116@qq.com");
        helper.setTo("2242757980@qq.com");
        //helper.setCc("37xxxxx37@qq.com");
        //helper.setBcc("14xxxxx098@qq.com");
        helper.setSentDate(new Date());
        helper.setText("这是测试邮件的正文");
        // 第一个参数是自定义的名称，后缀需要加上，第二个参数是文件的位置
        helper.addAttachment("java8实战.pdf",new File("D:/zhanghan/Downloads/Java 8实战.pdf"));
        javaMailSender.send(mimeMessage);
    }


    /**
     * 正文中带图片的邮件
     * @throws MessagingException
     */
    @Test
    public void sendImgResMail() throws MessagingException, MalformedURLException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("这是一封带图片的测试邮件");
        helper.setFrom("2366120116@qq.com");
        helper.setTo("2242757980@qq.com");
        //helper.setCc("37xxxxx37@qq.com");
        //helper.setBcc("14xxxxx098@qq.com");
        helper.setSentDate(new Date());
        // src='cid:p01' 占位符写法 ，第二个参数true表示这是一个html文本
        helper.setText("<p>hello 大家好，这是一封测试邮件，这封邮件包含两种图片，分别如下</p><p>第一张图片：</p><img src='cid:p01'/><p>第二张图片：</p><img src='cid:p02'/>",true);
        // 第一个参数指的是html中占位符的名字，第二个参数就是文件的位置
        helper.addInline("p01",new FileSystemResource(new File("D:/zhanghan/Pictures/06170330.jpg")));
        helper.addInline("p02",new FileUrlResource(new URL("https://img2020.cnblogs.com/blog/1992305/202011/1992305-20201111225618218-1806609583.png")));
        javaMailSender.send(mimeMessage);
//        https://img2020.cnblogs.com/blog/1992305/202011/1992305-20201111225618218-1806609583.png
    }


}
