const INF = Infinity
const arr = [
  [0, 2, 5, 1, INF, INF],
  [2, 0, 3, 2, INF, INF],
  [5, 3, 0, 3, 1, 5],
  [1, 2, 3, 0, 1, INF],
  [INF, INF, 1, 1, 0, 2],
  [INF, INF, 5, INF, 2, 0],
]

// 모든 꼭지점 미방문 상태
const isVisit = new Array(5).fill(false)

const getMin = function(vertex) {
  let min = INF;
  let idx = 0;
  for (let i = 0; i < vertex.length; i++) {
    // 방문하지 않은 정점 중에서 가장 가까운 정점 선택
    if (vertex[i] < min && !isVisit[i]) {
      min = vertex[i];
      idx = i;
    }
  }
  // 방문하지 않은 정점 중에서 가장 가까운 정점을 방문하도록 리턴
  return idx;
}

const dist = function(start) {
  // 시작 정점 정하기
  let v = arr[start - 1];
  let min = 0;
  let startV = v;
  isVisit[start - 1] = true;

  for (let i = 0; i < v.length; i++) {
    const idx = getMin(startV); // 가장 가까운 정점 선택 D
    min += startV[idx]; // 거리 추가 + 1
    const next = arr[idx]; // 거리 갱신을 위해 가장 가까운 정점 선택 D
    
    for (let i = 0; i < v.length; i++) {
      if (v[i] > next[i] + min && !isVisit[i]) {
        // 시작점에서의 거리가 가장 가까운 정점인 D를 경유해서 가는 거리보다 크고, 방문한 적이 없으면 거리 정보 갱신
        v[i] = next[i] + min;
      }
      // console.log(`i: ${i}, v: ${v}`)
    }
    startV = arr[idx]; //정점 방문
    isVisit[idx] = true;
  }
}

const main = (function() {
  dist(1)
}())