package Model;

import java.io.File;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class PasswordResetPage implements EmailSender {
	//not implemented yet
	@Override
	public boolean sendMail(InternetAddress email, MimeMessage msg) {
		return false;
	}
	
	//not implemented yet
	@Override
	public boolean sendMailWithAttachment(InternetAddress email, MimeMessage msg, File attachment) {
		return false;
	}

}
