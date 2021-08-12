const solution = (c, _houses) => {
  let wifi = 0, 
      left = 0, 
      right = Math.max(..._houses)
  let houses = [..._houses].sort()
  let prev = houses[0]

  let mid
  // let counter = 0

  while (left <= right) {
    // if (++counter > 1) break;
    mid = Math.floor((left + right) / 2)

    for (let i = 1; i < houses.length; i++) {
      if (prev + mid <= houses[i]) {
        wifi++
      }
    }
    if (wifi >= c) {
      left = mid + 1
    } else {
      right = mid - 1
    }
  }
  console.log(right)
}

solution(
  3,
  [1, 2, 8, 4, 9]
)