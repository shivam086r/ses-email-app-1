package com.example;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;

public class SESMailApp {

    private static final String FROM = "shivamrahangdale92@gmail.com";  // SES Verified email
    private static final String TO = "shivamrahangdale92@gmail.com";            // Recipient email
    private static final String SUBJECT = "Test Email from SES";
    private static final String BODY = "This is a test email sent using AWS SES";

    public static void main(String[] args) {
        // AWS SES access credentials (replace these with your credentials)
        String accessKey = "AWS_ACCESS_KEY";
        String secretKey = "AWS_SECRET_ACCESS_kEY";

        if (accessKey == null || secretKey == null || accessKey.isEmpty() || secretKey.isEmpty()) {
            System.out.println("AWS credentials not properly set.");
            return;
        }

        // AWS SES Configuration for Mumbai region (ap-south-1)
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonSimpleEmailService sesClient = AmazonSimpleEmailServiceClientBuilder.standard()
                .withRegion("ap-south-1")  // Mumbai region
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
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
