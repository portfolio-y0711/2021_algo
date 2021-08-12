// https://www.acmicpc.net/problem/1991

// 이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.

// 예를 들어 위와 같은 이진 트리가 입력되면,

// 전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
// 중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
// 후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
// 가 된다.


const solution = (_nodes, start) => {
  const nodes = _nodes.reduce((acc, curr) => {
    const str = curr.split(" ")
    acc[str[0]] = [str[1], str[2]]
    return acc
  }, {})

  const preorder = (node) => {
    if (node == '.') {
      return
    } 
    process.stdout.write(node)
    preorder(nodes[node][0])
    preorder(nodes[node][1])
  }
  const inorder = (node) => {
    if (node == '.') {
      return
    } 
    inorder(nodes[node][0])
    process.stdout.write(node)
    inorder(nodes[node][1])
  }
  const postorder = (node) => {
    if (node == '.') {
      return
    } 
    postorder(nodes[node][0])
    postorder(nodes[node][1])
    process.stdout.write(node)
  }

  preorder("A")
  console.log()
  inorder("A")
  console.log()
  postorder("A")
  
}

solution(
  [
    "A B C",
    "B D .",
    "C E F",
    "E . .",
    "F . G",
    "D . .",
    "G . .",
  ],
  "A"
)