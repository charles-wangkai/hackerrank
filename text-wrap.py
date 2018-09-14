#!/usr/bin/env python3

import textwrap

def main():
    S = input()
    w = int(input())
    
    print(textwrap.fill(S, w))

if __name__ == '__main__':
    main()
