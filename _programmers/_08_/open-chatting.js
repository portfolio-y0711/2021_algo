// https://programmers.co.kr/learn/courses/30/lessons/42888


const table = {
  "Enter": () => {
    return `님이 들어왔습니다.`
  },
  "Leave": () => {
    return `님이 나갔습니다.`
  },
  "Change": () => {
    return null
  }
}

function solution(record) {
  const [records, userMap] = record.reduce(([
    _records, _userMap
  ], x) => {
    const [op, id, username] = x.split(' ')

    if (["Enter", "Change"].includes(op)) {
      _userMap[id] = username
    }

    _records.push([op, id])
    return [_records, _userMap]
  }, [[], {}])

  return records.reduce((acc, [op, id]) => {
    const operation = table[op]()
    if (operation) {
      acc.push(userMap[id] + operation)
    }
    return acc
  }, [])
}

// console.log(solution([
// "Enter uid1234 Muzi",
// "Enter uid4567 Prodo",
// "Leave uid1234",
// "Enter uid1234 Prodo",
// "Change uid4567 Ryan"
// ]))

console.log(solution(
  ["Enter uid1234 Muzi",
  "Enter uid4567 Prodo",
  "Leave uid1234",
  "Enter uid1234 Prodo",
  "Change uid4567 Ryan"]

))
