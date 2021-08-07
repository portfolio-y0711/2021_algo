const getPermutations = (arr, selectNumber) => {
  if (selectNumber === 1) 
    return arr.map((value) => [value]);

  const results = [];
  arr.forEach((selected, idx, _arr) => {
    const rest = [
      ..._arr.slice(0, idx),
      ..._arr.slice(idx + 1)
    ] 
    const permutations = comb(rest, selectNumber - 1); // 나머지에 대해 순열을 구한다.
    const attached = permutations.map((permutation) => [
      selected,
      ...permutation
    ]);
    results.push(... attached); 
  });

  return results; 
};

const result = comb([1, 2, 3, 4], 2);
// console.log(result);
