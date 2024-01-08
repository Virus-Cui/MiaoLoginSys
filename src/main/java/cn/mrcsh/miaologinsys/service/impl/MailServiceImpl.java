package cn.mrcsh.miaologinsys.service.impl;

import cn.mrcsh.miaologinsys.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * @Date: 2023/9/21 20:13
 * @Author: Virus_Cui
 */
@Service
@Slf4j
public class MailServiceImpl implements MailService {

    @Value("${email.title}")
    public String title;
    @Value("${email.from}")
    public String from;
    @Value("${email.text}")
    public String text;



    @Autowired
    private JavaMailSender sender;

    @Override
    public void sendEmail(String email, String content) {
        try {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = null;
            helper = new MimeMessageHelper(message, true);

            helper.setFrom(from);
            helper.setTo(email);
            helper.setSubject(title); // 标题
            helper.setText(content); // 内容
            helper.setSentDate(new Date());
            sender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
