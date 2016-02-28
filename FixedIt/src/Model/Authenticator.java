package Model;

import java.io.File;
import java.math.BigInteger;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Authenticator implements EmailSender {
	public static final String allowedChars="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!.-_";
	
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

	public boolean validateNewUser(User newUser){
		return false;
	}
	public boolean addNewUserToDB(User newUser){
		return false;
	}
	public boolean isValidPassword(String password){
		if(password.length()>=8){
			for(int i=0; i<password.length(); i++){
				if(!allowedChars.contains(""+password.charAt(i))){
					return false;
				}
			}
			return true;
		}
		else{
			return false;
		}
	}
	public boolean isValidEmailAddress(String emailAddress){
		return false;
	}
	private URL requestPasswordReset(String email){
		return null;
	}
	
	/**
	 * salts and hashes password; built using tutorial at
	 * http://howtodoinjava.com/security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/#PBKDF2WithHmacSHA1
	 * @param password password to salt and hash
	 * @return salted hashed password
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public String saltHashPassword(String password){
		int iterations=20000;
		char[] chars = password.toCharArray();
		byte[] salt;
		try {
			salt = getSalt().getBytes();
			PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			byte[] hash = skf.generateSecret(spec).getEncoded();
			return iterations + ":" + toHex(salt) + ":" + toHex(hash);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
			return null;
		}		
	}
	/**
	 * used for salt+hash; built using tutorial at
	 * http://howtodoinjava.com/security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/#PBKDF2WithHmacSHA1
	 * @return salt
	 * @throws NoSuchAlgorithmException
	 */
	private String getSalt() throws NoSuchAlgorithmException{
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }
	/**
	 * translate to hex; built using tutorial at
	 * http://howtodoinjava.com/security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/#PBKDF2WithHmacSHA1
	 * @param array byte array to translate
	 * @return hex representation of byte array
	 * @throws NoSuchAlgorithmException
	 */
	private String toHex(byte[] array) throws NoSuchAlgorithmException{
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0){
            return String.format("%0"  +paddingLength + "d", 0) + hex;
		}
        else{
		    return hex;
		}
	}
	
	/**
	 * Validates the user's salted+hashed password with the one entered by the user
	 * at login; built using tutorial at 
	 * http://howtodoinjava.com/security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/#PBKDF2WithHmacSHA1
	 * 
	 * @param originalPassword the password entered by the user at login
	 * @param storedPassword the user's password as stored in the database
	 * @return	boolean true if valid, false if not
	 */
	public boolean validatePassword(String originalPassword, String storedPassword){
		String[] parts = storedPassword.split(":");
		int iterations = Integer.parseInt(parts[0]);
		byte[] salt = fromHex(parts[1]);
		byte[] hash = fromHex(parts[2]);
		byte[] testHash=null;

		PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8);
		SecretKeyFactory skf;
		try {
			skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			testHash = skf.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		

		int diff = hash.length ^ testHash.length;
		for (int i = 0; i < hash.length && i < testHash.length; i++) {
			diff |= hash[i] ^ testHash[i];
		}
		return diff == 0;
	}

	/**
	 * translates byte array from hex; built using tutorial at
	 * http://howtodoinjava.com/security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/#PBKDF2WithHmacSHA1
	 * @param hex the hex to decode
	 * @return bytes the translated byte array
	 */
	private byte[] fromHex(String hex) {
		byte[] bytes = new byte[hex.length() / 2];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
		}
		return bytes;
	}
	private boolean credentialsMatch(String email, String password){
		return false;
	}
	private Session createSession(User user){
		return null;
	}
	private URL generatePasswordResetPage(String email){
		return null;
	}
}
