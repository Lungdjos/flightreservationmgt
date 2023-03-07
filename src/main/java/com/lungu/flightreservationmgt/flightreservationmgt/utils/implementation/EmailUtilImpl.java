package com.lungu.flightreservationmgt.flightreservationmgt.utils.implementation;

import com.lungu.flightreservationmgt.flightreservationmgt.utils.EmailUtil;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class EmailUtilImpl implements EmailUtil {
    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void sendItinerary(String toAddress, String filePath) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        // creating a mail
        mimeMessageHelper.setTo(toAddress);
        mimeMessageHelper.setSubject("Itinerary for your flight reserved");
        mimeMessageHelper.setTo("Hi there, \nKindly find the attached file you your flight reservation.");
        mimeMessageHelper.addAttachment("Itinerary", new File(filePath));

        // sending the email
        javaMailSender.send(mimeMessage);


    }
}
