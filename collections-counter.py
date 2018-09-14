#!/usr/bin/env python3

import collections

def main():
    X = int(input())
    size2count = collections.Counter(map(int, input().split()))
    
    earned = 0
    N = int(input())
    for _ in range(N):
        size, price = map(int, input().split())
        if size in size2count and size2count[size]:
            size2count[size] -= 1
            earned += price
    
    print(earned)

if __name__ == '__main__':
    main()
