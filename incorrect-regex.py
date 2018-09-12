#!/usr/bin/env python3

import re


def solve(S):
    try:
        re.compile(S)
        return True
    except re.error:
        return False


def main():
    T = int(input())
    for _ in range(T):
        S = input()
        print(solve(S))


if __name__ == '__main__':
    main()
