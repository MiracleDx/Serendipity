package com.serendipity.cloud.common.email;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class EmailApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}

	@Resource
	private JavaMailSender mailSender;
	
	@Resource
	private TemplateEngine templateEngine;
	
	/**
	 * Callback used to run the bean.
	 *
	 * @param args incoming application arguments
	 * @throws Exception on error
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {
		simpleMail();
		attachmentMail();
		inlineMail();
		templateMail();
	}

	/**
	 * 简单邮件
	 */
	private void simpleMail() {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("dongxiang@pt.picc.com.cn");
		message.setTo("liuchang@pt.picc.com.cn", "weimaomao@sinosoft.com.cn");
		message.setSubject("主题：简单邮件");
		message.setText("Hello World!!!");
		
		mailSender.send(message);
	}

	/**
	 * 带有附件的邮件
	 * @throws MessagingException
	 */
	private void attachmentMail() throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("dongxiang@pt.picc.com.cn");
		helper.setTo(new String[]{"liuchang@pt.picc.com.cn", "weimaomao@sinosoft.com.cn", "dongxiang@sinosoft.com.cn"});
		helper.setSubject("主题：附件邮件");
		helper.setText("Hello World With Attachment !!!");

		FileSystemResource file = new FileSystemResource(new File("D:\\work\\picc_work\\cloud\\common-email\\pom.xml"));
		helper.addAttachment("附件-POM文件", file);
		helper.addAttachment(file.getFilename(), file);
		
		mailSender.send(mimeMessage);
	}

	/**
	 * 带有静态文件的邮件
	 * @throws MessagingException
	 */
	private void inlineMail() throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("dongxiang@pt.picc.com.cn");
		helper.setTo(new String[]{"liuchang@pt.picc.com.cn", "weimaomao@sinosoft.com.cn", "dongxiang@sinosoft.com.cn"});
		helper.setSubject("主题：带图片的邮件");
		helper.setText("Hello World With <html><body><img src=\"cid:dota\"></body></html> !!!", true);
		
		FileSystemResource file = new FileSystemResource(new File("D:\\dota.jpg"));
		helper.addInline("dota", file);
		
		mailSender.send(mimeMessage);
	}

	/**
	 * 模版邮件
	 * @throws MessagingException
	 */
	private void templateMail() throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("dongxiang@pt.picc.com.cn");
		helper.setTo(new String[]{"liuchang@pt.picc.com.cn", "weimaomao@sinosoft.com.cn", "dongxiang@sinosoft.com.cn"});
		helper.setSubject("主题：模版邮件");
		
		Map<String, Object> model = new HashMap<>();
		model.put("username", "liuchang");

		Context context = new Context();
		context.setVariables(model);
		String emailText = templateEngine.process("template", context);
	
		helper.setText(emailText, true);
		
		mailSender.send(mimeMessage);
	}
}
