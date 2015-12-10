#!/usr/bin/env python3

import itertools

def main():
    N = int(input())
    letters = input().split()
    K = int(input())
    
    combinations = list(itertools.combinations(letters, K))
    
    print(len(list(filter(lambda combination: 'a' in combination, combinations))) / len(combinations))

if __name__ == "__main__":
    main()
