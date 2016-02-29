package tests;

import static org.junit.Assert.*;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.junit.Before;
import org.junit.Test;

import Model.Authenticator;

public class EmailSenderTest {
	Authenticator a;
	@Before
	public void setUp() throws Exception {
		a=new Authenticator();
	}

	@Test
	public void testSendMail() {
		try {
			assertTrue(a.sendMail(new InternetAddress("mjones44@ycp.edu"), "test test test"));
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
