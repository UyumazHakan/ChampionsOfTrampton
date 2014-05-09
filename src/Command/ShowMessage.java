package Command;

public class ShowMessage implements Command {
  public static final int ALERT_MESSAGE=0;
  public static final int CONGRAT_MESSAGE=1;
  public static final int BUG_MESSAGE=2;

  private String message;
  private int messageType;

  public ShowMessage(int messageType,String message){
    this.message=message;
    this.messageType=messageType;

  }
  public void execute(){

  }
}