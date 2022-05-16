import java.util.Objects;

/**
 * This class initialize the field and member method of Song class
 */
public class Song {
  private String songName; // name or title of the song
  private String artist; // artist of the song
  private String duration; // duration of the song

  /**
   * Creates a new Song given the song name, the name of the artist, and the duration of the song
   *
   * @param songName title of the song
   * @param artist name of the artist who performed this song
   * @param duration duration of the song in the format mm:ss
   * @throws IllegalArgumentException  if either of songName, or artist, or duration is null or is
   *         blank, or if the duration is not formatted as mm:ss where both mm and ss are in the 0 .. 59
   *         range.
   */
  public Song(String songName, String artist, String duration) throws IllegalArgumentException {
    String[] durationArr = duration.split(":");
    if(songName.isBlank() || artist.isBlank()||duration.isBlank()|| !duration.contains(":")||
     Integer.parseInt(durationArr[0])>59||Integer.parseInt(durationArr[0])<0
      ||Integer.parseInt(durationArr[1])>59||Integer.parseInt(durationArr[1])<0)
      throw new IllegalArgumentException("blank song's name or artist's name or duration or illegal"
        + "form of duration");

    this.songName = songName;
    this.artist = artist;
    this.duration = duration;
  }

  /**
   * Gets the title or name of this song
   *
   * @return the title or name of this song
   */
  public String getSongName() {
    return songName;
  }

  /**
   * Gets the name of the artist who performed this song
   *
   * @return the artist who performed this song
   */
  public String getArtist() {
    return artist;
  }

  /**
   * Gets the duration of this song
   *
   * @return the duration
   */
  public String getDuration() {
    return duration;
  }

  /**
   * Returns a string representation of this song. This string should be formatted as follows.
   * "songName---artist---duration" where songName is the title of the song, artist is the name of
   * the artist, and duration is the duration of the song.
   *
   * @return a string representation of this song.
   */
  @Override public String toString() {
    return this.songName + "---" + this.artist + "---" + this.duration + "\n";
  }

  /**
   * Returns true when this song's name and artist strings equals to the other song's name and artist
   * strings, and false otherwise. Note that this method takes an Object rather than a Song argument,
   * so that it Overrides Object.equals(Object). If an object that is not an instance of Song is ever
   * passed to this method, it should return false.
   *
   * @param o Song object to compare this object to
   * @return true when the this song has matching name and artist with respect to another song
   * (case insensitive comparison)
   */
  @Override public boolean equals(Object o) {
    if (o instanceof Song && this.getSongName().equals(((Song) o).getSongName()) &&
      this.getArtist().equals(((Song) o).getArtist()))
      return true;
      return false;
  }
}
