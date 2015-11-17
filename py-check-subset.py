#!/usr/bin/env python3

def main():
    for i in range(int(input())):  # More than 4 lines will result in 0 score. Blank lines won't be counted. 
        a = int(input()); A = set(input().split())
        b = int(input()); B = set(input().split())
        print('True' if A.union(B) == B else 'False')

if __name__ == '__main__':
    main()
