#!/usr/bin/env python3

import collections

def main():
    n, m = map(int, input().split())
    
    word2indices = collections.defaultdict(list)
    for i in range(n):
        word2indices[input()].append(i + 1)
    
    for i in range(m):
        word = input()
        if word2indices[word]:
            print(*word2indices[word])
        else:
            print(-1)

if __name__ == "__main__":
    main()
