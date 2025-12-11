package ie.atu.abstraction;

public class NotificationManager {
    public void sendNotification(MessageService service, String message){
        System.out.println("Preparing to send notification...");
        service.sendMessage(message);
        System.out.println("Notification sent successfully!");
    }
}
