#!/usr/bin/env python3

import collections

def main():
    N = int(input())
    
    d = collections.deque()
    for _ in range(N):
        command, *args = input().split()
        getattr(d, command)(*args)
    
    print(*d)

if __name__ == '__main__':
    main()
