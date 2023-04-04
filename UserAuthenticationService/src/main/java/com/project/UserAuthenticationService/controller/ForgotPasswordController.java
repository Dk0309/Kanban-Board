package com.project.UserAuthenticationService.controller;

import com.project.UserAuthenticationService.exception.UserNotFoundException;
import com.project.UserAuthenticationService.service.UserService;
import com.project.UserAuthenticationService.utility.Utility;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@RestController
public class ForgotPasswordController {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private UserService userService;
   private ResponseEntity<?> responseEntity;

    @PostMapping("/forgot_password")
    public ResponseEntity<?> processForgotPassword(HttpServletRequest request) {

//        String email = user.getEmail();
        String email = request.getParameter("email");
        System.out.println(email);
        String token = RandomString.make(30);

        try {
            userService.updateResetPasswordToken(token, email);
            String resetPasswordLink = Utility.getSiteUrl(request) + "/reset_password?token=" + token;
            sendEmail(email, resetPasswordLink);
           responseEntity = new ResponseEntity("We have sent a reset password link to your email. Please check.",HttpStatus.OK);
        } catch (UserNotFoundException ex) {
            responseEntity = new ResponseEntity("User Not Found", HttpStatus.NOT_FOUND);
        } catch (UnsupportedEncodingException | MessagingException e) {
           responseEntity = new ResponseEntity("error! while sending mail",HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }
    public void sendEmail(String recipientEmail, String link)
            throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("ddmhelpdesk@gmail.com", "HelpDesk Support");
        helper.setTo(recipientEmail);

        String subject = "Here's the link to reset your password";

        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + link + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        mailSender.send(message);
    }

    @PostMapping("/reset_password")
    public String processResetPassword() {
        return "";
    }
}
