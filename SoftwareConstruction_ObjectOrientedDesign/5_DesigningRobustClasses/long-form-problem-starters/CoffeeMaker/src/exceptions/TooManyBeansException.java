package exceptions;

public class TooManyBeansException extends BeansAmountException {

    private double beans;
    private static String message = "Too many Beans.";

    public TooManyBeansException(double beans) {
        super(beans, message);
        this.beans = beans;
    }

    public String getMessege() {
        return beans + " " + message;
    }
}
