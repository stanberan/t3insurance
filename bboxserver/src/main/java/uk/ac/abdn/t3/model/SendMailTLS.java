package uk.ac.abdn.t3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
 
public class SendMailTLS {

	
 public void sendMail(String recipient, String body){
	 
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
	 try {
		    HttpPost request = new HttpPost("http://homepages.abdn.ac.uk/e.pignotti/pages/t3_mail_notofication.php");
		    StringEntity params = new StringEntity(body);
		    String to=recipient;
		    String subject="Your Premium has increased. ";
		    String message=body;
		    String key="FCEhJTkSNLuydXECDwjs7U9PDq1EgrO8";
		    
		    
		    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
		      nameValuePairs.add(new BasicNameValuePair("to", to));
		      nameValuePairs
		          .add(new BasicNameValuePair("subject", subject));
		      nameValuePairs.add(new BasicNameValuePair("message",message));
		      nameValuePairs.add(new BasicNameValuePair("key",
		         key));
		     

		      request.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		   HttpResponse resp= httpClient.execute(request);
		  System.out.println("StatusCode: "+ resp.getStatusLine().getStatusCode());
	 }
	 catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 
	 
	 
	
 }/*
	public void sendMail(String recipient,String body) {
 
		
		
		   System.getProperties().put("http.proxyHost","proxy.abdn.ac.uk");
		   System.setProperty("http.proxyPort",8080);
		final String username = "contact@stanberan.org";
		final String password = "pass";   //this is not real.
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "mail.stanberan.org");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("premium-no-reply@bboxinsureltd.co.uk"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(recipient));
			message.setSubject("Increased Premium!");
			message.setText(body);
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}*/
	
	public static void main(String args[]){
		
		new SendMailTLS().sendMail("contact@stanberan.org", "Hello from BBOX INSURE LTD.");
	
		
	}
}