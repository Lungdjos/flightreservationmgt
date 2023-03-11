package com.lungu.flightreservationmgt.flightreservationmgt.utils.implementation;

import com.lungu.flightreservationmgt.flightreservationmgt.utils.EmailUtil;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class EmailUtilImpl implements EmailUtil {
    // injection of configured properties
    @Value("${com.lungu.flightreservationmgt.flightreservationmgt.itinerary.email.subject}")
    private String EMAIL_SUBJECT;
    @Value("${com.lungu.flightreservationmgt.flightreservationmgt.itinerary.email.body}")
    private String EMAIL_BODY;
    // creating the logger instance
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtilImpl.class);
    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void sendItinerary(String toAddress, String filePath) throws MessagingException {
        // creating a logging
        LOGGER.info("Inside the bookFlight() with incoming values to: {} and file path: {}.", toAddress, filePath);

        // creating a logging
        LOGGER.info("Invoking the java mail sender");
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        // creating a logging
        LOGGER.info("The java maile sender: {} and the mime message helper: {} created");

        // creating a mail
        mimeMessageHelper.setTo(toAddress);
        mimeMessageHelper.setSubject(EMAIL_SUBJECT);
        mimeMessageHelper.setTo(EMAIL_BODY);
        mimeMessageHelper.addAttachment("Itinerary", new File(filePath));
        // creating a logging
        LOGGER.info("The created mail is: " + mimeMessageHelper);

        // sending the email
        javaMailSender.send(mimeMessage);
        // creating a logging
        LOGGER.info("Mail send to recipient");


    }
}
