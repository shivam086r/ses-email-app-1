package com.example;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;

public class SESMailApp {

    private static final String FROM = "shivamrahangdale92@gmail.com";  // SES Verified email
    private static final String TO = "shivam.rahangdale@paybyte.company";            // Recipient email
    private static final String SUBJECT = "Test Email from SES";
    private static final String BODY = "This is a test email sent using AWS SES";

    public static void main(String[] args) {
        // Initialize the SES client using the default credential provider chain
        AmazonSimpleEmailService sesClient = AmazonSimpleEmailServiceClientBuilder.standard()
                .withRegion("ap-south-1")  // Mumbai region
                .build();

        try {
            sendEmail(sesClient);
            System.out.println("Email sent successfully.");
        } catch (Exception e) {
            System.out.println("Error occurred while sending email: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void sendEmail(AmazonSimpleEmailService sesClient) throws Exception {
        SendEmailRequest sendEmailRequest = new SendEmailRequest()
                .withSource(FROM)
                .withDestination(new Destination().withToAddresses(TO))
                .withMessage(new Message()
                        .withSubject(new Content().withData(SUBJECT))
                        .withBody(new Body().withText(new Content().withData(BODY))));

        sesClient.sendEmail(sendEmailRequest);
    }
}
