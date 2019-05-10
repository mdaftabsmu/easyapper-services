package com.easyapper.emailservices.utils;

import com.easyapper.emailservices.dto.AmazonDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;

public class AmazonSESUtils {

    private Logger logger = LoggerFactory.getLogger(AmazonSESUtils.class);

    public void sendEmail(AmazonDTO amazonDTO) {
        Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.port", amazonDTO.getSmtpServerPort());
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        Transport transport=null;
        Session session = Session.getDefaultInstance(props);
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(amazonDTO.getFromUserEmail(), amazonDTO.getFromUserFullName()));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(amazonDTO.getToEmail()));
            msg.setSubject(amazonDTO.getSubject());
            msg.setContent(amazonDTO.getBody(), "text/html");
            msg.setHeader("X-SES-CONFIGURATION-SET", "ConfigSet");
            transport = session.getTransport();
            logger.info("Sending...");
            transport.connect(amazonDTO.getSmtpServerHost(), amazonDTO.getSmtpUserName(), amazonDTO.getSmtpUserPassword());
            transport.sendMessage(msg, msg.getAllRecipients());
            logger.info("Email sent! to this email id " + amazonDTO.getToEmail());
        } catch (Exception ex) {
            logger.error("The email was not sent.");
            logger.error("Error message: " + ex.getMessage());
        } finally {
            if(transport!=null){
                try {
                    transport.close();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
