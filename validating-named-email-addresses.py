#!/usr/bin/env python3

import re


def is_valid_email(email):
    return re.fullmatch(r'[a-zA-Z][a-zA-Z0-9\-._]+@[a-zA-Z]*\.[a-zA-Z]{1,3}', email) is not None


def main():
    n = int(input())
    for _ in range(n):
        fields = input().split()
        name = fields[0]
        email = fields[1][1:-1]

        if is_valid_email(email):
            print('{} <{}>'.format(name, email))


if __name__ == '__main__':
    main()
