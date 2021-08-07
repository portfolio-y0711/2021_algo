import java.security.cert.CollectionCertStoreParameters;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static java.util.Map.Entry.comparingByValue;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toMap;
import static java.util.Map.Entry;




class Solution {
  class Song {
    private String genre;
    private Integer play;
    private Integer index;

    public Song(String genre, Integer play, Integer index) {
      this.genre = genre;
      this.play = play;
      this.index = index;
    }

    @Override
    public String toString() {
      return String.format("%s %s %s", genre, play, index);
    }

    public String getGenre() {
      return this.genre;
    }
  }

  public int[] solution(String[] genres, int[] plays) {
    
    List<Song> songs = 
      IntStream
        .range(0, genres.length)
        .mapToObj(i -> new Song(genres[i], plays[i], i))
        .collect(Collectors.toList());

    Map<String, List<Song>> genreMap = 
      songs
        .stream()
        .collect(Collectors.groupingBy(s -> s.genre));



    LinkedHashMap<String, List<Song>> sortedGenreMap = new LinkedHashMap<>();
    // System.out.println(
      genreMap
        .entrySet()
        .stream()
        .sorted(new Comparator<Entry<String, List<Song>>>(){
          public int compare(Entry<String, List<Song>> a1, Entry<String, List<Song>> a2)  {
            return a2.getValue().size() - a1.getValue().size();
          }
        });

        // .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new))
    // );
    
    return new int[]{};
  }
}

class BestAlbum {
  public static void main(String[] args) {
    // System.out.println(
    new Solution()
      .solution(
        new String[] {
          "classic", "pop", "classic", "classic", "pop"
        },
        new int[] {
          500, 600, 150, 800, 2500
        }
      );
    // );
  }
}