package Model;

import java.io.File;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public interface EmailSender {
	public boolean sendMail(InternetAddress email, MimeMessage msg);
	public boolean sendMailWithAttachment(InternetAddress email, MimeMessage msg, File attachment);
}
