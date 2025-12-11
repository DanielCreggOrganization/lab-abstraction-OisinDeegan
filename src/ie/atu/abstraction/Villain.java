package ie.atu.abstraction;

public class Villain implements GameCharacter{
    @Override
    public void move() {
        System.out.println("John Villain floats over to his destination");
        
    }
    @Override
    public void speak() {
        System.out.println("\"NYEHEHE, it is I, JOHN VILLAIN!\"");
        
    }
    @Override
    public void useItem() {
        System.out.println("John Villain pulls out a gun and stabs with it");
    }
}
