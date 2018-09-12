#!/usr/bin/env python2


def solve(x, k):
    return input() == k


def main():
    x, k = map(int, raw_input().split())
    print(solve(x, k))


if __name__ == '__main__':
    main()
