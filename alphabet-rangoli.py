#!/usr/bin/env python3

import string

def main():
    N = int(input())
    
    alphabet = string.ascii_lowercase[:N]
    
    height = N * 2 - 1
    width = N * 4 - 3
    lines = [None] * height
    for i in range(N):
        sub_alphabet = alphabet[(-i - 1):]
        letters = ''.join(reversed(sub_alphabet)) + sub_alphabet[1:]
        lines[i] = lines[-i - 1] = '-'.join(letters).center(width, '-')
    
    print(*lines, sep='\n')

if __name__ == "__main__":
    main()
