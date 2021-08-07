// https://programmers.co.kr/learn/courses/30/lessons/72411?language=kotlin

const comb = (arr, selectNumber) => {
  if (selectNumber === 1) 
    return arr.map((value) => [value]);

  const results = arr.reduce((acc, selected) => {
    const idx = arr.findIndex(e => e == selected)
    const rest = [
      // ...arr.slice(0, idx),
      ...arr.slice(idx + 1)
    ] 
    const restSelec = comb(rest, selectNumber - 1); // 나머지에 대해 순열을 구한다.
    const attached = restSelec.map((restSelected) => [
      selected,
      ...restSelected
    ]);
    acc.push(... attached); 
    return acc
  }, []);

  return results; 
};

const result = comb([1, 2, 3, 4, 5], 2);
console.log(result);
