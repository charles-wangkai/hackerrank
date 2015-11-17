#!/usr/bin/env python3

def read_set():
    return set(map(int, input().split()))

def main():
    input()
    A = read_set()
    
    N = int(input())
    for _ in range(N):
        command = input().split()[0]
        s = read_set()
        
        getattr(A, command)(s)
    
    print(sum(A))

if __name__ == "__main__":
    main()
