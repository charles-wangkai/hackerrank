#!/usr/bin/env python3

def main():
    N = int(input())
    values = map(int, input().split())
    print(hash(tuple(values)))

if __name__ == '__main__':
    main()
