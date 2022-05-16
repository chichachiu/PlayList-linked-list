import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class models an iterator through elements of Song in front/head to back/tail order
 */
public class ForwardSongIterator implements Iterator<Song> {
  private LinkedNode<Song> next;//reference to the next linked node in a list of nodes

  /**
   * Creates a new iterator which iterates through songs in front/head to back/tail order
   *
   * @param first reference to the head of a doubly linked list of songs
   */
  public ForwardSongIterator(LinkedNode<Song> first) {
    this.next = first;
  }

  /**
   * This method checks whether there are more songs to return
   *
   * @return returns true if the iteration has more elements in a forward sequence
   */
  @Override public boolean hasNext() {
    return next!=null;
  }

  /**
   * This method returns the next song in the iteration
   *
   * @return the next song in the iteration
   * @throws if there are no more songs to return in the reverse order (meaning if this.hasNext()
   * returns false)
   */
  @Override public Song next() throws NoSuchElementException {
    if(!this.hasNext())
      throw new NoSuchElementException("the song list is empty");
    Song song= next.getData();
    next=next.getNext();
    return song;
  }
}

