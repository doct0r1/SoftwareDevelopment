package exceptions;

public class NotEnoughBeansException extends BeansAmountException {

    private double beans;
    private static String message = "Not Enough Beans.";

    public NotEnoughBeansException(double beans, String message) {
        super(beans, message);
    }

    public String getMessege() {
        return beans + " " + message;
    }
}
