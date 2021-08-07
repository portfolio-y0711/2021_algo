function solution(relation) {
  var rows = relation.length;
  var columns = relation[0].length;

  const isUnique = (keyMap) => Object.keys(keyMap).length == rows
  const isMinimal = (pool, recordKey) => {
    for (var i = 0; i < pool.length; i++) {
      // console.log(`answers[i] & now: ${answers[i] & now}, answers[i]: ${answers[i]}, result: ${(answers[i] & now) == answers[i]}`)
      if ((pool[i] & recordKey) == pool[i]) {
        return false;
      }
    }
    return true;
  }

  const combinations = [...Array(1 << columns).keys()]
    .reduce((_combinations, i) => {
      const keyMap = [...Array(rows).keys()]
        .reduce((_keyMap, j) => {
          const records = [...Array(columns).keys()]
            .reduce((_records, k) => {
              if (i & (1 << k)) {
                _records.push(relation[j][k])
              }
              return _records
            }, [])
          const recordKey = records.join("-")
          if (recordKey.length > 0) {
            if (recordKey in _keyMap) {
              _keyMap[recordKey] = _keyMap[recordKey] + 1
            } else {
              _keyMap[recordKey] = 1
            }
          }
          return _keyMap
        }, {})

        return isUnique(keyMap) && isMinimal(_combinations, i) 
          ? [..._combinations, i] : _combinations
    }, [])
  return combinations.length;
}

console.log(
  solution(
  [
    ["100","ryan","music","2"],
    ["200","apeach","math","2"],
    ["300","tube","computer","3"],
    ["400","con","computer","4"],
    ["500","muzi","music","3"],
    ["600","apeach","music","2"]
  ]	
  )
)
