#!/usr/bin/env python3

def read_set():
    return set(input().split())

def main():
    A = read_set()
    N = int(input())
    sets = [read_set() for _ in range(N)]
    print('True' if all(map(lambda s: A.union(s) == A and A != s, sets)) else 'False')

if __name__ == "__main__":
    main()
