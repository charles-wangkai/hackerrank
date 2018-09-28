#!/usr/bin/env python3

import re


def main():
    N = int(input())
    inside = False
    for _ in range(N):
        line = input()

        if '{' in line:
            inside = True
        elif '}' in line:
            inside = False
        elif inside:
            for m in re.finditer(r'#[0-9a-fA-F]{3}([0-9a-fA-F]{3})?', line):
                print(m.group())


if __name__ == '__main__':
    main()
