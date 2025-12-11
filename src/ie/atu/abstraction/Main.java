package ie.atu.abstraction;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle("Red", 5.0);
        Shape square = new Square("Blue", 5.0);

        System.out.println("The circle is colored "+circle.color+" and has an area of "+circle.getArea());
        System.out.println("The square is colored "+square.color+" and has an area of "+square.getArea());

        GameCharacter zero = new Hero();
        GameCharacter lero = new Villain();

        zero.speak();
        lero.speak();
        zero.move();
        lero.move();
        zero.useItem();
        lero.useItem();
        System.out.println();

        Student stud = new Student("Oisin", 19);
        stud.introduce();
        stud.doHomework();
        stud.study();

        NotificationManager manager = new NotificationManager();
        MessageService whatsapp = new WhatsAppService();
        MessageService sms = new SmsService();
        System.out.println();
        System.out.println("---Sending a message by whatsapp---");
        manager.sendNotification(whatsapp, "Hello from WhatsApp");
        System.out.println();
        System.out.println("---Sending a text message by SMS");
        manager.sendNotification(sms, "Howdy from SMS");

        System.out.println(whatsapp.receiveMessage());
        System.out.println(sms.receiveMessage());
    }
}
