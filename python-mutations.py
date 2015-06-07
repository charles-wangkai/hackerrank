#!/usr/bin/env python3

def main():
    S = input()
    i, c = input().split()
    i = int(i)
    print(S[:i] + c + S[i + 1:])

if __name__ == '__main__':
    main()
