package week11;

public interface PhoneInterface {
    
    // 상수
    final int TIMEOUT = 10000; // 
    void sendCall();           // 추
    void receiveCall();        // 추
    
    default void printLogo() { // 
        System.out.println("** Phone **");
    }
}