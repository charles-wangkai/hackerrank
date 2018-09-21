#!/usr/bin/env python3

import re


def solve(S):
    vowel = '[aeiou]'
    consonant = '[qwrtypsdfghjklzxcvbnm]'
    return re.findall(r'{consonant}({vowel}{{2,}})(?={consonant})'.format(vowel=vowel, consonant=consonant), S, re.IGNORECASE)


def main():
    S = input()

    solution = solve(S)
    if solution:
        print(*solution, sep='\n')
    else:
        print(-1)


if __name__ == '__main__':
    main()
