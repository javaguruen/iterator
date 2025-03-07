package no.hamre.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class BjornCollection<Type> implements Iterable<Type> {

  private ArrayList<Type> list = new ArrayList<>();

  public void add(Type type) {
    list.add(type);
  }

  @Override
  public Iterator<Type> iterator() {
    return new BjornIterator();
  }

  @Override
  public void forEach(Consumer<? super Type> action) {
    Iterable.super.forEach(action);
  }

  @Override
  public Spliterator<Type> spliterator() {
    return Iterable.super.spliterator();
  }

  private class BjornIterator implements Iterator<Type> {

    private int position = 0;

    @Override
    public boolean hasNext() {
      return position < list.size();
    }

    @Override
    public Type next() {
      return list.get(position++);
    }

    @Override
    public void remove() {
      list.remove(position - 1);
      position--;
    }

    @Override
    public void forEachRemaining(Consumer<? super Type> action) {
      Iterator.super.forEachRemaining(action);
    }
  }
}
