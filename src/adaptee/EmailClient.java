package adaptee;

public final class EmailClient {
    public void deliver(String text){
        System.out.println("Email -> "+text);
    }
}