#!/usr/bin/env python3


def solve(a, b):
    return int(a) // int(b)


def main():
    T = int(input())
    for _ in range(T):
        a, b = input().split()

        try:
            print(solve(a, b))
        except Exception as e:
            print('Error Code:', e)


if __name__ == '__main__':
    main()
