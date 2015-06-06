#!/usr/bin/env python3

def main():
    M = input()
    setM = set(input().split())
    N = input()
    setN = set(input().split())
    
    for i in sorted(map(int, setM.symmetric_difference(setN))):
        print(i)

if __name__ == "__main__":
    main()
