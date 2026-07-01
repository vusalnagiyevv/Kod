package com.example.TikintiMateriallari.services.impls;

import com.example.TikintiMateriallari.services.EmailService;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {


    private final JavaMailSender mailSender;

    @Override
    public boolean getConfirmationEmail(String token, String email) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(email);
            helper.setFrom("nagiyevv853@gmail.com");
            helper.setSubject("Əliyarliİnşaat Qeydiyyatınız Təsdiqləndi");

            // Bura öz login səhifənizin real URL ünvanını yazmalısınız (məsələn: http://localhost:3000/login və s.)
            String loginUrl = "http://localhost:8080/verify?token=" + token;

            // E-poçtun içində görünəcək HTML və Düymə (Button) dizaynı
            String htmlContent = "<div style='font-family: Arial, sans-serif; text-align: center; padding: 20px;'>"
                    + "<h2>Əliyarliİnşaat-a Xoş Gəlmisiniz!</h2>"
                    + "<p>Qeydiyyatınızı tamamlamaq və hesabınızı təsdiqləmək üçün aşağıdakı düyməyə klikləyin:</p>"
                    + "<br>"
                    + "<a href='" + loginUrl + "' style='"
                    + " background-color: #4CAF50;"
                    + " color: white;"
                    + " padding: 14px 25px;"
                    + " text-align: center;"
                    + " text-decoration: none;"
                    + " display: inline-block;"
                    + " font-size: 16px;"
                    + " border-radius: 5px;"
                    + " font-weight: bold;"
                    + "'>Hesabı Təsdiqlə və Daxil Ol</a>"
                    + "<br><br><br>"
                    + "<p style='color: #777; font-size: 12px;'>Əgər düymə işləmirsə, bu linkə keçid edin: <a href='" + loginUrl + "'>" + loginUrl + "</a></p>"
                    + "</div>";

            // İkinci parametri 'true' etmək vacibdir ki, mətnin HTML olduğunu anlasın
            helper.setText(htmlContent, true);

            mailSender.send(message);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
