#!/usr/bin/env python3

import itertools

def main():
    S, k = input().split()
    k = int(k)
    
    print(*map(lambda combination: ''.join(combination), itertools.combinations_with_replacement(sorted(S), k)), sep='\n')

if __name__ == "__main__":
    main()
