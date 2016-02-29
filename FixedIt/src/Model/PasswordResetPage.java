package Model;

import java.util.Date;

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
	
	public static final String baseMessage=
			"<h2>Dear FixedIt User,</h2>" +
			"<h2>&nbsp; &nbsp; &nbsp; You have requested a password reset. " + 
			"If this is an error or you did not request a password reset, you " + 
			"can simply ignore this email and your password will remain unchanged. " +
			"To reset your password, you can click the link below and follow the " +
			"instructions on your password reset page.</h2>" +
			"<p>&nbsp;</p>" +
			"<p>&nbsp;</p>";
	public static final String endMessage=
			"<p>&nbsp;</p>" +
			"<p>&nbsp;</p>" +
			"<center><img src=\"http://s11.postimg.org/97dahnc2r/fixedit_logo.jpg\"/></center>";
}
