package ie.atu.abstraction;

public class Hero implements GameCharacter{
    @Override
    public void speak() {
        System.out.println("\"It is me, John Hero!\"");
    }
    @Override
    public void useItem() {
        System.out.println("John Hero pulls out a gun and shoots");
    }
    @Override
    public void move() {
        System.out.println("John Hero runs over to his destination");
    }
}
