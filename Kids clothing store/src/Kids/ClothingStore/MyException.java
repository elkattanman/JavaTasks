package Kids.ClothingStore;

public class MyException extends Exception {

    private String Message;

    public MyException() {
        super("Sorry ,There an Error in System");
        this.Message = "Sorry ,There an Error in System";
    }

    public MyException(String Message) {
        super(Message);
        this.Message = Message;
    }

    public MyException(Exception ex) {
        super(ex);
        this.Message = ex.getMessage();
    }

    @Override
    public String getMessage() {
        return Message; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "MyException{" + "Message=" + Message + '}';
    }

}
