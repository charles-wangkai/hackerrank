#!/usr/bin/env python3

import re


def solve(S):
    m = re.search(r'([a-zA-Z0-9])\1', S)
    return m.group(1) if m else -1


def main():
    S = input()
    print(solve(S))


if __name__ == '__main__':
    main()
