#!/usr/bin/env python3

import itertools

def read_numbers():
    return map(int, input().split())

def main():
    K, M = read_numbers()
    lists = [list(read_numbers())[1:] for _ in range(K)]
    
    print(max(map(lambda combination: sum(map(lambda x: x * x, combination)) % M, itertools.product(*lists))))

if __name__ == '__main__':
    main()
