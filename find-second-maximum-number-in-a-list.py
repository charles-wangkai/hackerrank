#!/usr/bin/env python3

def solve():
    N = int(input())
    A = list(map(int, input().split()))
    
    print(sorted(set(A))[-2])
    
if __name__ == "__main__":
    solve()