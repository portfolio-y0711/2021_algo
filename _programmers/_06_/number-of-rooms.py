#!/usr/bin/env python
# -*- coding: utf-8 -*-

def solution(arrows):
    move = [
        (-1, 0),
        (-1, 1),
        (0, 1),
        (1, 1),
        (1, 0),
        (1, -1),
        (0, -1),
        (-1, -1)]
    print(move[6][0])
    edge = []
    vertex = [(0, 0)]
    current = (0, 0)
    room = 0
    for i in arrows:
        current = vertex[-1]
        a, b = current[0] + move[i][0], current[1] + move[i][1]
        if (a, b) in vertex:
            if (current[0], current[1], a, b) in edge or (a, b, current[0], current[1]) in edge:
                continue
            else:
                edge.append((current[0], current[1], a, b))
                vertex.append((a, b))
                room += 1
        else:
            edge.append((current[0], current[1], a, b))
            vertex.append((a, b))
    return room


print(solution(
    [6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0]
))
