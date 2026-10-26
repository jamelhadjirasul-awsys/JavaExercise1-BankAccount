package exception;

/**
 * Thrown when an operation is performed on a frozen account.
 */
public class InvalidAmountException extends Exception {

  private String message;

  public InvalidAmountException(String message) {
    super(message);
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

}
