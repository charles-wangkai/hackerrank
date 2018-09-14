#!/usr/bin/env python3

import itertools

def main():
    S, k = input().split()
    k = int(k)
    
    for i in range(1, k + 1):
        print(*map(lambda combination: ''.join(combination), itertools.combinations(sorted(S), i)), sep='\n')

if __name__ == '__main__':
    main()
