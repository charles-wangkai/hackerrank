#!/usr/bin/env python3

def read_set():
    n = int(input())
    return set(input().split())

def main():
    print(len(read_set().union(read_set())))

if __name__ == "__main__":
    main()
