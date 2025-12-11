package ie.atu.abstraction;

public interface MessageService {
    void sendMessage(String message);
    String receiveMessage();
}
