import java.util.Queue;
import java.util.Deque;

/*
  This class returns queue with maximum value.
 */
public class QueueWithMaxJava <T> {
  Queue <Integer> queue;
  Deque <Integer>  candidatesForMax;

  void enQueue (int  value)
  {
      while (!candidatesForMax.isEmpty())
      {
          if(candidatesForMax.getLast() >= value)
          {
              break;
          }
          candidatesForMax.removeLast();
      }
      candidatesForMax.addLast(value);
  }

  Integer deQueue ()
  {
      if (!queue.isEmpty())
      {
          Integer result = queue.peek();
          if(result == candidatesForMax.getFirst())
          {
              candidatesForMax.removeFirst();
          }
          queue.poll();
          return result;
      }
      return -1;
  }

  Integer Max()
  {
      if (!candidatesForMax.isEmpty())
      {
          return candidatesForMax.getFirst();
      }
      return -1;
  }
}

