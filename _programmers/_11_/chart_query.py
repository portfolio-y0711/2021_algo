from itertools import combinations

def createmap(records):
  recordmap = {}
  scores = []
  for x in records:
    li = x.split()
    properties = li[:-1]
    value = int(li[-1])
    scores.append(value)
    for i in range(len(li)):
      for c in combinations(properties, i):
        key = '-'.join(c)
        if key in recordmap:
          recordmap[key].append(value)
        else:
          recordmap[key] = [value]
  recordmap[None] = scores
  return recordmap

def extractkey(query):
  qlist = query.split(' ')
  qlist = list(filter(lambda x : (x != '-') and (x != 'and') , qlist))
  properties = qlist[:-1]

  if (len(properties) == 0):
    key = None
  else: 
    key = '-'.join(properties)

  value = int(qlist[-1])
  return key, value

def querydata(recordmap, query):
  answer = []
  for q in query:
    key, value = extractkey(q)
    # print(f'key: {key}, value: {value}')

    if key in recordmap:
      scores = recordmap[key]
      scores.sort()

      # print(f'key: {key}, scores: {scores}')

      if len(scores) > 0:
        start, end = 0, len(scores)
        while start < end:
          mid = (start + end) // 2
          if scores[mid] >= value:
            end = mid
          else:
            start = mid + 1
        # print(start)
        answer.append(len(scores) - start)

    else:
      answer.append(0)
  return answer

def solution(info, query):
  recordmap = createmap(info)
  data = querydata(recordmap, query)
  return data


result = solution(
  [
    "java backend junior pizza 150",
    "python frontend senior chicken 210",
    "python frontend senior chicken 150",
    "cpp backend senior pizza 260",
    "java backend junior chicken 80",
    "python backend senior chicken 50"
  ],
  [
    "java and backend and junior and pizza 100",
    "python and frontend and senior and chicken 200",
    "cpp and - and senior and pizza 250",
    "- and backend and senior and - 150",
    "- and - and - and chicken 100",
    "- and - and - and - 150"
    ]	
)
print(result)