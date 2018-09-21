#!/usr/bin/env python3

import re


def solve(S, k):
    return [(m.start(1), m.end(1) - 1) for m in re.finditer(r'(?=({}))'.format(k), S)]


def main():
    S = input()
    k = input()

    solution = solve(S, k)
    if solution:
        print(*solution, sep='\n')
    else:
        print((-1, -1))


if __name__ == '__main__':
    main()
