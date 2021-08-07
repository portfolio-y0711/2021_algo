// https://programmers.co.kr/learn/courses/30/lessons/42627

const solution = (_jobs) =>{
  let time = 0
  let cursor = 0
  let response_time = 0
  let jobs = [..._jobs]
    .sort((a, b) => a[0] - b[0])
  const pq = []
  while (cursor < jobs.length || pq.length) {
    // producer
    if (cursor < jobs.length) {
      if (jobs[cursor][0] <= time) {
        // console.log('--- producing ---')
        // console.log(jobs[cursor])
        pq.push(jobs[cursor])
        pq.sort((a, b) => a[1] - b[1])
        cursor++ // 다음 작업을 가리킴
        continue
      }
    }
    // consumer
    if (pq.length == 0) {
      // console.log('--- wating ---')
      time = jobs[cursor][0]
    } else {
      // console.log('--- consuming ---')
      const [begin, work_time] = pq.shift()
      // console.log(`[ ${begin}, ${work_time} ]`)
      response_time = response_time + time + work_time - begin
      time = time + work_time
    }
  }
  return Math.floor(response_time / _jobs.length)
}

console.log(
  solution(
    [
      [1, 9], 
      [0, 3], 
      [2, 6]
    ],
    // [
    //   [0, 3], 
    //   [1, 9], 
    //   [2, 6]
    // ]	    
  )
)