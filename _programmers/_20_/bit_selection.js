
const createSubset = (arr) => {
  const n = arr.length
  const subsetList = []
  for (i = 0; i < 1 << n; i++) {
    const result = []
    for (j = 0; j < n; j++) {
      // console.log(`    j: ${j}`)
      if (i & (1 << j)) {
        result.push(arr[j])
      }
      // console.log(`i: ${i}, j: ${j}, (i << j): ${i << j}, i & (1 << j): ${i & (1 << j)}, result: ${result}`)
    }
    subsetList.push(result)
  }
  return subsetList
}

const subsets = createSubset(
  [
    "100",
    "ryan",
    "music",
    "2"
  ]
)

console.log(subsets
  .filter(x => x.length > 0)
  .map(x => x.join('-'))
  )


