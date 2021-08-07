
def DFS (L, start): 
  if L == r:
    print(result)
  else: 
    for i in range(start, len(n)):
      result[L] = i
      DFS(L + 1, i + 1)

if __name__ == "__main__":
  n = [1,2,3]
  r = 2

  result = [0] * r
  
  DFS(0, 0)