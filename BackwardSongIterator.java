import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class models an Iterator which can iterate from tail to head
 */
public class BackwardSongIterator implements Iterator<Song> {
  private LinkedNode<Song> next; //reference to the next linked node in a list of nodes

  /**
   *  a new iterator which iterates through songs in back/tail to front/head order
   *
   * @return reference to the tail of a doubly linked list of songs
   */
  public BackwardSongIterator(LinkedNode<Song> last) {
    this.next = last;
  }

  /**
   * Checks whether there are more songs to return in the reverse order
   *
   * @return returns true if the iteration has more elements in a backward sequence
   */
  @Override public boolean hasNext() {
    return next!=null;
  }

  /**
   * Returns the next song in the iteration
   *
   * @return returns the next song in the iteration in a backward sequence
   * @throws NoSuchElementException if this list is empty.
   */
  @Override public Song next() throws NoSuchElementException {
    if(!this.hasNext())
      throw new NoSuchElementException("the song list is empty");
    Song song= next.getData();
    next=next.getPrev();
    return song;
  }
}
