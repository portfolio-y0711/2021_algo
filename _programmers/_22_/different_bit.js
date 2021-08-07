const solution = (numbers) => {
  return numbers.reduce((answer, number) => {
    let str = "0" + number.toString(2);
    const l = str.length;

    if (str[l - 1] === "0") {
      return [...answer, number + 1]
    } else {
      for (let i = str.length; i >= 0; i--) {
        if (str[i] === "0") {
          return [...answer, parseInt(str.substring(0, i) + "1" + "0" + str.substring(i + 2, l), 2)];
        }
      }
    }
  }, []);
}


console.log(solution([2, 7]))
