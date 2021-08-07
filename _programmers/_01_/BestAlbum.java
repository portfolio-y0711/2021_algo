import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static java.util.Map.Entry;

class Solution {
  class Song {
    private Integer play;
    private Integer index;

    public Song(Integer play, Integer index) {
      this.play = play;
      this.index = index;
    }

    @Override
    public String toString() {
      return String.format("%s %s", play, index);
    }
    public Integer getPlay() { return this.play; };
    
    public Integer getIndex() { return this.index; };
  }

  public int[] solution(String[] genres, int[] plays) {
    
      Map<String, List<Song >> songSets = 
        IntStream
          .range(0, genres.length)
          .mapToObj(i -> Map.entry(genres[i], new Song(plays[i], i)))
          .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
      
        
     List<Integer> indexes = songSets 
        .entrySet()
        .stream()
        .sorted(new Comparator<Entry<String, List<Song>>>(){
          public int compare(Entry<String, List<Song>> a1, Entry<String, List<Song>> a2)  {
            return a2.getValue().stream().mapToInt(l -> l.getPlay()).sum()
            - a1.getValue().stream().mapToInt(l -> l.getPlay()).sum();
        }})
        .map(e -> e.getValue().stream().sorted(new Comparator<Song>() {
          public int compare(Song a1, Song a2) {
              return a2.getPlay() - a1.getPlay();
          }
        }).limit(2).collect(Collectors.toList()))
        .flatMap(e -> e.stream().map(s -> s.getIndex()) )
        .collect(Collectors.toList());
    
      System.out.println(indexes);
      int [] answer = indexes.stream().mapToInt(i -> i).toArray();
      return answer; 
  }
}

class BestAlbum {
  public static void main(String[] args) {
    System.out.println(
    new Solution()
      .solution(
        new String[] {
          "classic", "pop", "classic", "classic", "pop"
        },
        new int[] {
          500, 600, 150, 800, 2500
        }
      )
    );
  }
}