#!/usr/bin/env python3

import re


def solve(N):
    return re.fullmatch(r'[+-]?\d*\.\d+', N) is not None


def main():
    T = int(input())
    for _ in range(T):
        N = input()
        print(solve(N))


if __name__ == '__main__':
    main()
