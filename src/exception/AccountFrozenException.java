package exception;

/**
 * Thrown when an operation is performed on a frozen account.
 */
public class AccountFrozenException extends Exception {

  private String message;

  public AccountFrozenException(String message) {
    super(message);
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

}
