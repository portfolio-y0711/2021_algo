// https://programmers.co.kr/learn/courses/30/parts/12077

// 곡의 장르가 기록된 리스트와 재생 횟수 리스트를 인자로 받으면
// 가장 먼저 노래 별로 장르와 인덱스 순서, 재생횟수를 매핑해주는 zip 연산을 해야함
// 장르별 총 재생횟수와 장르 내 재생횟수 순서로 연산을 해야하므로 
// 먼저 장르명을 키로 사용하여 장르 리스트를 해시테이블로 구성함
// 해시테이블을 리스트로 변환하고 맵 연산을 통해 장르 리스트를 장르별 총 재생횟수 기준으로 내림차순으로 정렬함
// 현재 엔트리에는 장르명 키와 인덱스가 기록되어 있는데, 맵 연산을 통해 이를 인덱스와 장르별 재생 리스트를 짝 짓고
// 짝 지워진 리스트 요소는 재생횟수 기준으로 내림차순 정렬함
// 파이프라이닝을 통해 리스트로부터 각 요소를 두개씩 선택하도록 함
// take 2 매핑이 끝난 리스트는 flatten 연산을 통해 병합 한뒤 결과값을 리턴함

class Solution01 {
  fun solution(genres: Array<String>, plays: IntArray): IntArray {
    
    val genresMap = genres.indices.groupBy { 
      genres[it]
    }
    
    val genresMapList = genresMap
      .entries
      .sortedByDescending { 
        it.value.map { idx -> plays[idx] }.sum()
       }

    val albumList = genresMapList.map { 
      it.value.map { idx -> Pair(idx, plays[idx]) }
      .sortedByDescending { 
        it.second
      }
      .take(2)
      .map { pair -> pair.first }
     }.flatten()
    return albumList.toIntArray()
  }
}

fun main(args: Array<String>) {
  println(Solution01().solution(
    arrayOf("classic", "pop", "classic", "classic", "pop"),
    intArrayOf(500, 600, 150, 800, 2500)
  ))
}