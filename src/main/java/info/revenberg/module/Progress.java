package info.revenberg.module;

public class Progress {
  private static int counter = 0;
  
  public static int getNext() {
    return Progress.counter++;    
  }
}
