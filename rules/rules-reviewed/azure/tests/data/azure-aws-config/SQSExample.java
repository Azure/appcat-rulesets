import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.*;

public class SQSExample {

    // Replace with your AWS region and SQS queue URL
    private static final String AWS_REGION = "us-west-2";
    private static final String QUEUE_URL = "your_sqs_queue_url";

    public static void main(String[] args) {
        // Create SQS client
        AmazonSQS sqs = AmazonSQSClientBuilder.standard()
                .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
                .withRegion(AWS_REGION)
                .build();

        try {
            // Send a message
            sendMessage(sqs, "Hello SQS!");

            // Receive messages
            receiveMessages(sqs);

        } finally {
            // Shutdown the SQS client
            sqs.shutdown();
        }
    }

    // Method to send a message to SQS queue
    private static void sendMessage(AmazonSQS sqs, String messageBody) {
        SendMessageRequest sendMsgRequest = new SendMessageRequest()
                .withQueueUrl(QUEUE_URL)
                .withMessageBody(messageBody);
        sqs.sendMessage(sendMsgRequest);
        System.out.println("Message sent to SQS queue.");
    }

    // Method to receive messages from SQS queue
    private static void receiveMessages(AmazonSQS sqs) {
        ReceiveMessageRequest receiveMsgRequest = new ReceiveMessageRequest()
                .withQueueUrl(QUEUE_URL)
                .withMaxNumberOfMessages(5); // Adjust as needed

        ReceiveMessageResult receiveMessageResult = sqs.receiveMessage(receiveMsgRequest);
        for (Message message : receiveMessageResult.getMessages()) {
            System.out.println("Message received: " + message.getBody());

            // Delete the message from the queue
            String messageReceiptHandle = message.getReceiptHandle();
            sqs.deleteMessage(new DeleteMessageRequest()
                    .withQueueUrl(QUEUE_URL)
                    .withReceiptHandle(messageReceiptHandle));
            System.out.println("Message deleted from SQS queue.");
        }
    }
}
