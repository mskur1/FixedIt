package tests;

import static org.junit.Assert.*;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.junit.Before;
import org.junit.Test;

import Model.Authenticator;
import Model.PasswordResetPage;

public class EmailSenderTest {
	Authenticator a;
	@Before
	public void setUp() throws Exception {
		a=new Authenticator();
	}

	@Test
	public void testSendMail() {
		assertTrue(a.sendMail("mjones44@ycp.edu", ""));
	}
}
