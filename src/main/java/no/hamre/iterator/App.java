package no.hamre.iterator;

import java.util.stream.IntStream;

/**
 * Hello world!
 */
public class App {

  public static void main(String[] args) {
    var collection = new BjornCollection<Integer>();
    IntStream.range(0, 10).forEach(collection::add);
    var iterator = collection.iterator();
    System.out.println("Gå gjennom med iterator");
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    System.out.println("Gå gjennom med 'enhanced for loop'");
    for (Integer integer : collection) {
      System.out.println(integer);
    }
  }
}
