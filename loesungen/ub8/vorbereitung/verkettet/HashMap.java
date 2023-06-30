package ub8.vorbereitung.verkettet

public interface HashMap<T> {
  public int getSize();
  public boolean contains(int key);
  public T get(int key);
  public void put(int key, T data);
  public void remove(int key);
} 