package ie.atu.abstraction;

public class Student extends Person implements Teachable {

    public Student(String input,int x){
        super(input, x);
    }
    @Override
    public void doHomework() {
        System.out.println(name+" is doing their homework");
    }
    @Override
    public void study() {
        System.out.println(name+" is studying");
    }
    @Override
    public void introduce() {
        System.out.println("\"My name is "+name+" and I'm "+age+" years old. I am a student.\"");
    }
}
