package Model;

import java.util.Calendar;

public class PasswordResetPage extends EmailSender {
	private String emailAddress;
	private Calendar expirationDate;
	private Authenticator a;
	private String url;
	
	public PasswordResetPage(Authenticator a, String emailAddress, Calendar expirationDate){
		this.emailAddress=emailAddress;
		this.expirationDate=expirationDate;
		this.a=a;
		generateAndSetURL();
	}
	//not implemented yet
	public boolean resetPassword(String password){
		return false;
	}
	
	public void renew(){
		
	}
	
	public String buildEmail(String firstHalf, String secondHalf){
		return firstHalf + "<h2><u><font color=\"blue\"><a href=\"" + url + "\">Reset Password</a></font></u></h2>" 
				+ secondHalf;
	}
	
	private void generateAndSetURL(){
		//not implemented yet
	}
}
