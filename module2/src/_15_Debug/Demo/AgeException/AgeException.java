package _15_Debug.Demo.AgeException;

public class AgeException extends Exception{
    AgeException(String message){
        super(message);
    }
    AgeException(){};
    AgeException(Throwable cause){
        super(cause );
    }
    AgeException(String message, Throwable cause) {
        super(message, cause);
    }
}
