#!/usr/bin/env python3

import itertools

def read_list():
    return map(int, input().split())

def main():
    A = read_list()
    B = read_list()
    
    print(*itertools.product(A, B))

if __name__ == "__main__":
    main()
