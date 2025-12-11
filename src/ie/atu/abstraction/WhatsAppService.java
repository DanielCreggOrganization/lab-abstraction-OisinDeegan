package ie.atu.abstraction;

public class WhatsAppService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("WhatsApp: Sending message - "+message);
    }
    @Override
    public String receiveMessage() {
        return "WhatsApp: New message received!";
    }
}
