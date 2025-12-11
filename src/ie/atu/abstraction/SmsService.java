package ie.atu.abstraction;

public class SmsService implements MessageService{
    @Override
    public void sendMessage(String message) {
        System.out.println("SMS: Sending text - "+message);
    }
    @Override
    public String receiveMessage() {
        return "New Text received from SMS";
    }
}
