import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements unit test methods to check the correctness of Song, LinkedNode, SongPlayer
 * ForwardSongIterator and BackwardSongIterator classes in P07 Iterable Song Player assignment.
 *
 */
public class SongPlayerTester {
  /**
   * This method test and make use of the Song constructor, an accessor (getter) method,
   * overridden method toString() and equal() method defined in the Song class.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSong() {
    Song favSong = new Song("Simple Love", "Jay Chou", "4:30");
    if (!favSong.getSongName().equals("Simple Love") || !favSong.getArtist().equals("Jay Chou")
      || !favSong.getDuration().equals("4:30")) {
      System.out.println("constructor Song fails");
      return false;
    }

    try {
      try {
        Song illegalSOng = new Song("", "Jay Chou", "4:30");
      } catch (IllegalArgumentException e) {
        e.printStackTrace();
      }
    } catch (Exception ex) {//unexpected exception
      ex.printStackTrace();
      System.out.println("unexpected exception in Song constructor");
      return false;
    }

    return true;
  }

  /**
   * This method test and make use of the LinkedNode constructor, an accessor
   * (getter) method, and a mutator (setter) method defined in the LinkedCart class.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedNode() {
    try {
      try{
      LinkedNode<Song> emptyNode= new LinkedNode<>(null, null, null);
      //}catch (IllegalArgumentException e){
        //throw new NoSuchElementException("data is null");
      }catch (NoSuchElementException e){
      e.printStackTrace();
      }
    }catch (Exception e){
      System.out.println("unexpected Exception for constructor in LinkedNode class");
      return false;
    }

    LinkedNode<Song> current = new LinkedNode<Song>(null, new Song("Mojito",
      "Jay Chou","3:05"), null);
    LinkedNode<Song> last = new LinkedNode<Song>(null, new Song("Clear Day",
      "Jay Chou","4:59"), null);
    LinkedNode<Song> first = new LinkedNode<Song>(null, new Song("Secret",
      "Jay Chou", "4:56"), null);
    current.setPrev(first);
    current.setNext(last);

    if(!(current.getData().getSongName()).equals("Mojito")||
      !(current.getData().getArtist()).equals("Jay Chou")|| !current.getData().getDuration().equals("3:05")){
      System.out.println("constructor for linkedNode is wrong");
      return false;
    }

    LinkedNode<Song> temp1 = current.getPrev();
    if (!temp1.getData().getSongName().equals("Secret") ||
      !temp1.getData().getArtist().equals("Jay Chou") ||
      !temp1.getData().getDuration().equals("4:56")) {
      System.out.println("LinkedNode constructor fails");
      return false;
    }

    LinkedNode<Song> temp2 = current.getNext();
    if (!temp2.getData().getSongName().equals("Clear Day") ||
      !temp2.getData().getArtist().equals("Jay Chou") ||
      !temp2.getData().getDuration().equals("4:59")) {
      System.out.println("LinkedNode constructor fails");
      return false;
    }

    return true;
  }

  /**
   * This method checks for the correctness of addFirst(), addLast() and add(int index)
   * method in SongPlayer class
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerAdd() {
    SongPlayer songList = new SongPlayer();
    songList.addFirst(new Song("Mojito", "Jay Chou", "3:05"));
    songList.addFirst(new Song("Secret", "Jay Chou", "4:56"));
    songList.addLast(new Song("StarBoy", "The Weeknd", "3:50"));
    songList.addLast(new Song("Superman Can’t Fly", "Jay Chou", "4:59"));
    songList.add(1, new Song("Simple Love", "Jay Chou", "4:30"));

    String actual= songList.play();
    String expected = "Secret---Jay Chou---4:56"+"\n"+"Simple Love---Jay Chou---4:30"+"\n"+
      "Mojito---Jay Chou---3:05"+"\n"+"StarBoy---The Weeknd---3:50"+"\n"+"Superman Can’t Fly---Jay Chou---4:59"+"\n";

    if(!actual.equals(expected)){
      System.out.println(" addFirst(), addLast() and add(int index) fail");
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of getFirst(), getLast() and get(int index)
   * method in SongPlayer class
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerGet() {
    SongPlayer songList = new SongPlayer();
    songList.addFirst(new Song("Mojito", "Jay Chou", "3:05"));
    songList.addFirst(new Song("Secret", "Jay Chou", "4:56"));
    songList.addLast(new Song("StarBoy", "The Weeknd", "3:50"));
    songList.addLast(new Song("Superman Can’t Fly", "Jay Chou", "4:59"));
    songList.add(1, new Song("Simple Love", "Jay Chou", "4:30"));

    String actualFirst = songList.getFirst().toString();
    String expectedFirst = "Secret---Jay Chou---4:56"+"\n";
    if(!actualFirst.equals(expectedFirst)){
      System.out.println(expectedFirst+actualFirst);
      System.out.println("getFirst() fails");
      return false;
    }
    String actualLast = songList.getLast().toString();
    String expectedLast = "Superman Can’t Fly---Jay Chou---4:59"+"\n";
    if(!actualLast.equals(expectedLast)){
      System.out.println("getLast() fails");
      return false;
    }
    String actualGet = songList.get(4).toString();
    String expectedGet = "Superman Can’t Fly---Jay Chou---4:59"+"\n";
    if(!actualGet.equals(expectedGet)){
      System.out.println("get(index) fails");
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of removeFirst(), removeLast() and remove(int index)
   * method in SongPlayer class
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerRemove() {
    SongPlayer songList = new SongPlayer();
    songList.addFirst(new Song("Mojito", "Jay Chou", "3:05"));
    songList.addFirst(new Song("Secret", "Jay Chou", "4:56"));
    songList.addLast(new Song("StarBoy", "The Weeknd", "3:50"));
    songList.addLast(new Song("Superman Can’t Fly", "Jay Chou", "4:59"));
    songList.add(1, new Song("Simple Love", "Jay Chou", "4:30"));

    String actual1 = songList.removeFirst().toString();
    String expected1 = "Secret---Jay Chou---4:56"+"\n";
    if(!actual1.equals(expected1)){
      System.out.println("removeFirst() fails");
      return false;
    }
    String actual2 = songList.removeLast().toString();
    String expectedLast = "Superman Can’t Fly---Jay Chou---4:59"+"\n";
    if(!actual2.equals(expectedLast)){
      System.out.println("removeLast() fails");
      return false;
    }
    String actual3 = songList.remove(0).toString();
    String expectedGet = "Simple Love---Jay Chou---4:30"+"\n";
    if(!actual3.equals(expectedGet)){
      System.out.println("remove(index) fails");
      System.out.println(actual3+expectedGet);
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of iterator(), switchPlayingDirection() and String play()
   * method in SongPlayer class
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerIterator() {
    SongPlayer songList = new SongPlayer();
    songList.addFirst(new Song("Mojito", "Jay Chou", "3:05"));
    songList.addFirst(new Song("Secret", "Jay Chou", "4:56"));
    songList.addLast(new Song("StarBoy", "The Weeknd", "3:50"));
    songList.addLast(new Song("Superman Can’t Fly", "Jay Chou", "4:59"));
    songList.add(1, new Song("Simple Love", "Jay Chou", "4:30"));

    String playAct = songList.play();
    String playExp = "Secret---Jay Chou---4:56"+"\n"+"Simple Love---Jay Chou---4:30"+"\n"+
      "Mojito---Jay Chou---3:05"+"\n"+"StarBoy---The Weeknd---3:50"+"\n"+
      "Superman Can’t Fly---Jay Chou---4:59"+"\n";
    if(!playAct.equals(playExp)){
      System.out.println("play() fails");
      return false;
    }

    songList.switchPlayingDirection();
    String playActInverse = songList.play();
    String playExpInverse = "Superman Can’t Fly---Jay Chou---4:59"+"\n"+"StarBoy---The Weeknd---3:50"
      +"\n"+ "Mojito---Jay Chou---3:05"+"\n"+"Simple Love---Jay Chou---4:30"+"\n"+
      "Secret---Jay Chou---4:56"+"\n";
    if(!playActInverse.equals(playExpInverse)){
      System.out.println("switchPlayingDirection() fails");
      return false;
    }

    String expIterator ="BackwardSongIterator";
    String  actualIterator= songList.iterator().toString();
    if(!actualIterator.contains(expIterator)){
      System.out.println("iterator() fails");
      return false;
    }

    return true;
  }

  /**
   * This method checks for the correctness of contains(Object song), clear(),
   * isEmpty()and size() method in SongPlayer class
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerCommonMethod() {
    SongPlayer songList = new SongPlayer();
    songList.addFirst(new Song("Mojito", "Jay Chou", "3:05"));
    songList.addFirst(new Song("Secret", "Jay Chou", "4:56"));
    songList.addLast(new Song("StarBoy", "The Weeknd", "3:50"));
    songList.addLast(new Song("Superman Can’t Fly", "Jay Chou", "4:59"));
    songList.add(1, new Song("Simple Love", "Jay Chou", "4:30"));

    int actualSize= songList.size();
    int expected = 5;
    if(actualSize!=expected){
      System.out.println("size() fails");
      return false;
    }
    boolean actualContain = songList.contains(new Song("Mojito", "Jay Chou", "3:05"));
    if(!actualContain){
      System.out.println("contains() fails");
      return false;
    }
    boolean actualIsEmpty = songList.isEmpty();
    if(actualIsEmpty){
      System.out.println("isEmpty() fails");
      return false;
    }
    songList.clear();
    boolean clear=songList.isEmpty();
    if(!clear){
      System.out.println("clear() fails");
      return false;
    }

    return true;
  }

  /**
   * This method checks for the correctness of ForwardSongIterator class
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testForwardSongIterator() {
    ForwardSongIterator forwardSongIterator= new ForwardSongIterator(null);

    try {
      if (forwardSongIterator.hasNext()) {
        System.out.println("hasNext contains a bug in forwardSongIterator");
        return false;
      }
      try {
        forwardSongIterator.next();
      }catch (NoSuchElementException e){
        e.printStackTrace();
      }
    }catch (Exception e){
      System.out.println("unexpected Exception for next() method");
      return false;
    }

    LinkedNode<Song> current = new LinkedNode<Song>(null, new Song("Mojito",
      "Jay Chou","3:05"), null);
    LinkedNode<Song> last = new LinkedNode<Song>(null, new Song("Clear Day",
      "Jay Chou","4:59"), null);
    LinkedNode<Song> first = new LinkedNode<Song>(null, new Song("Secret",
      "Jay Chou", "4:56"), null);
    current.setPrev(first);
    current.setNext(last);
    first.setNext(current);
    last.setPrev(current);

    forwardSongIterator=new ForwardSongIterator(first);
    if(!forwardSongIterator.hasNext()){
      System.out.println("hasNext() method for first node is wrong");
      return false;
    }
    Song temp1 = forwardSongIterator.next();
    if(!temp1.getSongName().equals("Secret")|| !temp1.getArtist().equals("Jay Chou")||
      !temp1.getDuration().equals("4:56")){
      System.out.println("next() method for first node is wrong");
      return false;
    }
    if(!forwardSongIterator.hasNext()){
      System.out.println("hasNext() method for second node is wrong");
      System.out.println(forwardSongIterator.next().getSongName());
      return false;
    }
    Song temp2 = forwardSongIterator.next();
    if(!temp2.getSongName().equals("Mojito")|| !temp2.getArtist().equals("Jay Chou")||
      !temp2.getDuration().equals("3:05")){

      System.out.println("next() method for second node is wrong");
      return false;
    }
    if(!forwardSongIterator.hasNext()){
      System.out.println("hasNext() method for last node is wrong");
      return false;
    }
    Song temp3 = forwardSongIterator.next();
    if(!temp3.getSongName().equals("Clear Day")|| !temp3.getArtist().equals("Jay Chou")||
      !temp3.getDuration().equals("4:59")){
      System.out.println("next() method for last node is wrong");
      return false;
    }

    return true;
  }

  /**
   * This method checks for the correctness of BackwardSongIterator class
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */

  public static boolean testBackwardSongIterator() {
    Song song1 = new Song("Clear Day", "Jay Chou", "04:07");
    Song song2 = new Song("Mojito", "Jay Chou", "04:00");
    Song song3 = new Song("Superman Can't Fly", "Jay Chou", "04:21");
    LinkedNode<Song> node2 = new LinkedNode<>(null, song2, null);
    LinkedNode<Song> node3 = new LinkedNode<>(node2, song3, null);
    LinkedNode<Song> node1 = new LinkedNode<>(null, song1, node2);
    node2.setPrev(node1);
    node2.setNext(node3);
    BackwardSongIterator backwardInstance = new BackwardSongIterator(node3);
    if (!backwardInstance.hasNext()) {
      return false;
    }
    String expectedName1 = "Superman Can't Fly";
    String actualName1 = backwardInstance.next().getSongName();
    if (!expectedName1.equals(actualName1)) {
      return false;
    }
    if (!backwardInstance.hasNext()) {
      return false;
    }
    String expectedName2 = "Mojito";
    String actualName2 = backwardInstance.next().getSongName();
    if (!expectedName2.equals(actualName2)) {
      return false;
    }
    if (!backwardInstance.hasNext()) {
      return false;
    }
    String expectedName3 = "Clear Day";
    String actualName3 = backwardInstance.next().getSongName();
    if (!expectedName3.equals(actualName3)) {
      return false;
    }
    if (!backwardInstance.hasNext()) {
      return false;
    }
    try {
      backwardInstance.next();
    } catch (NoSuchElementException e1) {
      System.out.println(e1.getMessage());
    } catch (Exception e) {
      System.out.println("fail the catch correct exception");
      return false;
    }
    return true;
  }


  /**
   * This method calls all the test methods defined and implemented in your SongPlayerTester
   * class.
   *
   * @return true if all the test methods defined in this class pass, and false otherwise.
   */
  public static boolean runAllTests() {
    if (!testSong() || !testLinkedNode() ||!testSongPlayerAdd()||
      !testSongPlayerGet()||!testSongPlayerRemove()||!testForwardSongIterator()||
    !testSongPlayerCommonMethod()||!testSongPlayerIterator()||!testBackwardSongIterator()){
      System.out.println("test fails");
      return false;
    }
      System.out.println("test pass");
    return true;
  }

  /**
   * Driver method defined in this SongPlayerTester class
   *
   * @param args input arguments if any.
   */
  public static void main(String[] args) {
    runAllTests();
  }
}
