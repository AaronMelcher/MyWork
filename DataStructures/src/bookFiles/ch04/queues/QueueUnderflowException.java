package bookFiles.ch04.queues;

public class QueueUnderflowException extends RuntimeException
{
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public QueueUnderflowException()
  {
    super();
  }

  public QueueUnderflowException(String message)
  {
    super(message);
  }
}