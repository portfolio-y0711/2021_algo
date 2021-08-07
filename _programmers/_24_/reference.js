// function solution(n, edge) {
//   const adj = [];
//   const inq = new array(n + 1).fill(-1);
//   const q = [];
//   const cost = new array(n + 1).fill(infinity);
//   edge.map(v => {
//       (adj[v[0]] || (adj[v[0]] = [])).push(v[1]);
//       (adj[v[1]] || (adj[v[1]] = [])).push(v[0]);
//   })

//   cost[1] = 1;
//   q.push(1);
//   while(q.length) {
//       const curr = q.shift();
//       adj[curr].map(next => {
//           if(cost[curr] + 1 < cost[next]) {
//               cost[next] = cost[curr] + 1;
//               if(inq[next] === -1) {
//                   inq[next] = 1;
//                   q.push(next);
//               }
//           }
//       })
//   }
//   let maxdist = cost.reduce((max, v) => v === infinity ? 0 : math.max(max, v), 0);
//   return cost.reduce((acc, n) => n === maxdist ? ++acc : acc, 0);
// }

// function solution(n, edge) {
//   const graph = new array(n+1).fill(0).map(el => []);
//   for(const el of edge){
//       const [x, y] = el;
//       graph[x].push(y);
//       graph[y].push(x);
//   }
//   const explored = new set();
//   const queue = [];
//   const map = new map();
//   let max = 0;
//   queue.push([1, 0])
//   while(queue.length > 0){
//       const [cur, dist] = queue.shift();
//       max = math.max(max, dist);
//       map.has(dist) ? map.set(dist, map.get(dist) + 1): map.set(dist, 1);
//       explored.add(cur);
//       for(let i=0; i<graph[cur].length; i++){
//           if(!explored.has(graph[cur][i]) && queue.findindex(el => el[0] === graph[cur][i]) <0)
//               queue.push([graph[cur][i], dist+1]);
//       }
//   }
//   return map.get(max);
// }


// function solution(n, edge) {
//   let cnt = 1, nodes_at = [[1]], used = new array(n+1); used[1] = true;
//   for(let i=1; ; i++){ 
//       nodes_at.push([]);
//       for(let j=0; j<nodes_at[i-1].length; j++){ 
//           let parent = nodes_at[i-1][j];
//           for(let k=0; k<edge.length; k++){
//               if(edge[k][0] == parent || edge[k][1] == parent){
//                   let child = edge[k][0]+edge[k][1]-parent;
//                   if(used[child] != true){
//                       nodes_at[i].push(child); 
//                       used[child] = true; cnt++;
//                   }
//                   edge.splice(k, 1); k--;
//               }
//           }
//       }
//       if(nodes_at[i].length == 0) return n-cnt;
//       if(n == cnt) return nodes_at[nodes_at.length-1].length;
//   }
// }


// function solution(n, edge) {
//   let deep = new Set([1]);

//   while (edge.length > 0) {
//     const temp = new Set([]);

//     edge = edge.reduce((acc, cur) => {
//       if (deep.has(cur[0]) && deep.has(cur[1])) return acc;
//       if (deep.has(cur[0])) temp.add(cur[1]);
//       else if (deep.has(cur[1])) temp.add(cur[0]);
//       else acc.push(cur);
//       return acc;
//     }, []);
//     if (temp.size > 0) deep = temp;
//   }

//   return deep.size;
// }

