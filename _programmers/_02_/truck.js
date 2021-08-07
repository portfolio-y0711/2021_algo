// https://programmers.co.kr/learn/courses/30/lessons/42583

function solution(bridge_length, weight, truck_weights) {
  let time = 0
  let trucks_on_bridge = Array(bridge_length).fill(0)
  let truck_q = [...truck_weights]
  while (trucks_on_bridge.length) {
    trucks_on_bridge.splice(0, 1)
    if (truck_q.length) {
      const total_weight = trucks_on_bridge.reduce((acc, curr) => acc + curr)
      if (total_weight + truck_q[0] <= weight) {
        const truck = truck_q.splice(0, 1)[0]
        trucks_on_bridge.push(truck)
      } else {
        trucks_on_bridge.push(0)
      }
    }
    time++
  }
  return time
}

const result = solution(2, 10, [7, 4, 5, 6])
console.log(result)
