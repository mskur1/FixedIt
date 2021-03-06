package Model;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.*;

public class EmailSender {
	/**
	 * Sends an email in HTML format to the given address.
	 * @param email the email address to send to
	 * @param text the text/HTML to set as the body of the message
	 * @return true if message is sent successfully, false if message fails to send
	 */
	public boolean sendMail(String email, String text) {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		javax.mail.Authenticator auth = new javax.mail.Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("fixeditwebmaster@gmail.com", "cs320abc");
			}
		};

		javax.mail.Session session = javax.mail.Session.getInstance(properties, auth);
		Message msg = new MimeMessage(session);
		
		try {
			InternetAddress address=new InternetAddress(email);
			InternetAddress[] toAddresses = { address };
			msg.setRecipients(Message.RecipientType.TO, toAddresses);
			msg.setSubject("Password Reset Request");
			msg.setSentDate(new Date());
			msg.setFrom(new InternetAddress("do-not-reply@FixedItScheduler.com", "FixedIt WebMaster"));
			msg.setReplyTo(new Address[]{new InternetAddress("do-not-reply@FixedItScheduler.com")});
			msg.setContent(text, "text/html");
			Transport transport=session.getTransport("smtp");
			transport.connect("smtp.gmail.com", "fixeditwebmaster@gmail.com", "cs320abc");
			transport.sendMessage(msg, msg.getAllRecipients());
			return true;
		} catch (MessagingException | UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
	}
}
