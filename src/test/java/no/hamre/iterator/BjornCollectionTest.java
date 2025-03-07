package no.hamre.iterator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BjornCollectionTest {

  @Test
  void add() {
    var collection = new BjornCollection<String>();
    var iterator = collection.iterator();
    assertFalse(iterator.hasNext());

    collection.add("Bjorn");
    assertTrue(iterator.hasNext());
    assertEquals("Bjorn", iterator.next());
  }

  @Test
  void next_on_emtpty_throws() {
    var collection = new BjornCollection<String>();
    var iterator = collection.iterator();
    assertThrows(IndexOutOfBoundsException.class, iterator::next);
  }

  @Test
  void remove() {
    var collection = new BjornCollection<String>();
    collection.add("Bjorn");
    collection.add("Per");
    var iterator = collection.iterator();
    assertTrue(iterator.hasNext());
    assertEquals("Bjorn", iterator.next());
    iterator.remove();
    assertEquals("Per", iterator.next());
  }
}
