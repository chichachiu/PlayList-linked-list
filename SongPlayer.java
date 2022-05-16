import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class models a iterable Song play list
 */
public class SongPlayer implements Iterable<Song> {
  private int size; // size of the list
  private LinkedNode<Song> head; // head of this doubly linked list
  private LinkedNode<Song> tail; // tail of this doubly linked list
  private boolean playingBackward; // true if this song player is reading the list backward

  /**
   * add Song as First Song
   *
   * @param oneSong the song that is going to be added to the head of this doubly linked list of
   *                songs
   * @throws NullPointerException with a descriptive error message if the passed oneSong is null
   */
  public void addFirst(Song oneSong) throws NullPointerException {
    if (oneSong == null) {
      throw new NullPointerException("the passed oneSong is null");
    } else if (size == 0) {
      tail = new LinkedNode<Song>(null, oneSong, null);
      head = tail;
    } else {
      LinkedNode<Song> newNode = new LinkedNode<Song>(null, oneSong, null);
      newNode.setNext(head);
      head.setPrev(newNode);
      head = newNode;
    }
    size++;
  }

  /**
   * Adds a Song as Last Song
   *
   * @param oneSong the song that is going to be added to the tail of this doubly linked list of
   *                songs
   */
  public void addLast(Song oneSong) {
    LinkedNode<Song> newNode = new LinkedNode<Song>(null, oneSong, null);
    if (size == 0) {
      head = newNode;
      tail = head;
    } else {
      newNode.setPrev(tail);
      tail.setNext(newNode);
      tail = newNode;
    }
    size++;
  }

  /**
   * adds Song at a given position/order within this collection of songs
   *
   * @param index   the given index where the new song will be added
   * @param oneSong the song that is going to be added
   * @throws NullPointerException      with a descriptive error message if the passed oneSong is
   *                                   null
   * @throws IndexOutOfBoundsException with a descriptive error message if index is out of the 0 ..
   *                                   size() range
   */
  public void add(int index, Song oneSong) throws NullPointerException, IndexOutOfBoundsException {
    if (oneSong == null) {
      throw new NullPointerException("the passed oneSong is null");
    } else if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("index is out bound");
    } else if (size == 0) {
      head = new LinkedNode<Song>(null, oneSong, null);
      tail = head;
    } else if (index == 0) {
      addFirst(oneSong);
    } else if (index == size) {
      addLast(oneSong);
    } else {
      LinkedNode<Song> work = head;
      for (int i = 0; i < index - 1; i++) {
        work = work.getNext();
      }
      LinkedNode<Song> newNode = new LinkedNode<Song>(null, oneSong, null);
      work.getNext().setPrev(newNode);
      newNode.setNext(work.getNext());
      work.setNext(newNode);
      newNode.setPrev(work);
    }
    size++;
  }

  /**
   * Returns the first Song in this list.
   *
   * @return the Song at the head of this list
   * @throws NoSuchElementException with a descriptive error message if this list is empty
   */
  public Song getFirst() throws NoSuchElementException {
    if (size == 0) {
      throw new NoSuchElementException("the list is empty");
    }
    return head.getData();
  }

  /**
   * Returns the last Song in this list.
   *
   * @return the Song at the tail of this list
   * @throws NoSuchElementException with a descriptive error message if this list is empty
   */
  public Song getLast() throws NoSuchElementException {
    if (size == 0) {
      throw new NoSuchElementException("the list is empty");
    }
    return tail.getData();
  }

  /**
   * Returns the song at the specified position in this list.
   *
   * @param index index of the song to return
   * @return the song at the specified position in this list
   * @throws IndexOutOfBoundsException with a descriptive error message if index is out of the 0 ..
   *                                   size()-1 range
   */
  public Song get(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index > size() - 1) {
      throw new IndexOutOfBoundsException("index is out of the 0 .. size()-1 range");
    }
    LinkedNode<Song> work = head;
    for (int i = 0; i < index; i++) {
      work = work.getNext();
    }
    return work.getData();
  }


  /**
   * Removes and returns the first song from this list.
   *
   * @return the first song from this list
   * @throws NoSuchElementException with a descriptive error message if this list is empty
   */
  public Song removeFirst() throws NoSuchElementException {
    if (size == 0) {
      throw new NoSuchElementException("this list is empty");
    } else if (size == 1) {
      LinkedNode<Song> work = head;
      head = null;
      tail = null;
      size = 0;
      return work.getData();
    } else {
      LinkedNode<Song> curr = head;
      head.getNext().setPrev(null);
      head = head.getNext();
      size--;
      return curr.getData();
    }
  }

  /**
   * Removes and returns the last song from this list.
   *
   * @return the last song from this list
   * @throws NoSuchElementException with a descriptive error message if this list is empty
   */
  public Song removeLast() throws NoSuchElementException {
    if (size == 0) {
      throw new NoSuchElementException("list is empty");
    } else if (size == 1) {
      LinkedNode<Song> work = tail;
      head = null;
      tail = null;
      size = 0;
      return work.getData();
    } else {
      LinkedNode<Song> work = tail;
      tail.getPrev().setNext(null);
      tail = tail.getPrev();
      size--;
      return work.getData();
    }
  }

  /**
   * Removes the song at the specified position in this list and returns the song that was removed
   * from the list. The order of precedence of the other songs in the list should not be modified.
   *
   * @param index the index of the song to be removed
   * @return the song previously at the specified position
   * @throws IndexOutOfBoundsException with a descriptive error message if index is out of the 0 ..
   *                                   size()-1 range
   */
  public Song remove(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index > (size - 1)) {
      throw new IndexOutOfBoundsException("index is out of the 0 .. size()-1 range");
    } else if (index == 0) {
      return removeFirst();
    } else if (index == size - 1) {
      return removeLast();
    } else {
      LinkedNode<Song> work = head;
      for (int i = 0; i < index; i++) {
        work = work.getNext();
      }
      work.getNext().setPrev(work.getPrev());
      work.getPrev().setNext(work.getNext());
      size--;
      return work.getData();
    }
  }

  /**
   * Returns true if this list contains a match with the specified song. More formally, returns true
   * if and only if this list contains at least one song e such that Objects.equals(o, e).
   *
   * @param o song whose presence in this list is to be tested
   * @return true if this list contains the specified song
   */
  public boolean contains(Song o) {
    LinkedNode<Song> work = head;
    while (work != null) {
      if (work.getData().equals(o)) {
        return true;
      } else {
        work = work.getNext();
      }
    }
    return false;
  }

  /**
   * Removes all of the songs from this list. The list will be empty after this call returns.
   */
  public void clear() {
    this.size = 0;
    this.head = null;
    this.tail = null;
  }

  /**
   * Returns true if this list is empty.
   *
   * @return true if this list is empty
   */
  public boolean isEmpty() {
    if (this.size == 0)
      return true;
    return false;
  }

  /**
   * Returns the number of songs in this list.
   *
   * @return the number of songs in this list
   */
  public int size() {
    return this.size;
  }

  /**
   * Returns an iterator to iterate through the songs in this list with respect to current playing
   * direction of this song player
   *
   * @return an Iterator to traverse the list of songs in this SongPlayer with respect to the
   * current playing direction specified by the playingBackward data field.
   */
  @Override public Iterator<Song> iterator() {
    if (playingBackward == true)
      return new BackwardSongIterator(tail);
    else
      return new ForwardSongIterator(head);
  }

  /**
   * Mutator of the playingDirection of this song player. It switches the playing direction by
   * setting playingBackward to its opposite value.
   */
  public void switchPlayingDirection() {
    if (playingBackward)
      playingBackward = false;
    else
      playingBackward = true;
  }

  /**
   * Plays the songs in this song player in the current playing direction. This method MUST be
   * implemented using an enhanced for-each loop.
   *
   * @return a String representation of the songs in this song player. String representations of
   * each song are separated by a newline. If this song player is empty, this method returns
   * an empty string.
   */
  public String play() {
    String result = "";
    if (!this.isEmpty()) {
      for (Song song : this) {
        result += song.toString();
      }
    }
    return result;
  }
}
