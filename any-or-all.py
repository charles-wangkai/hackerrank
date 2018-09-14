#!/usr/bin/env python3


def solve(numbers):
    return all(map(lambda x: x > 0, numbers)) and any(map(lambda x: str(x) == str(x)[::-1], numbers))


def main():
    input()
    numbers = list(map(int, input().split()))

    print(solve(numbers))


if __name__ == '__main__':
    main()
