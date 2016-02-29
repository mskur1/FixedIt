package Model;

import java.io.File;
import java.util.Date;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class PasswordResetPage extends EmailSender {
	private String emailAddress;
	private Date expirationDate;
	
	public PasswordResetPage(String emailAddress, Date expirationDate){
		this.emailAddress=emailAddress;
		this.expirationDate=expirationDate;
	}
	//not implemented yet
	public boolean resetPassword(String password){
		return false;
	}
	
	public void renew(){
		
	}
}
