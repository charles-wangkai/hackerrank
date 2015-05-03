#!/usr/bin/env python3

import re

def solve():
    N = int(input())
    emails = [input() for i in range(N)]
    
    print(sorted(list(filter(lambda email: re.fullmatch(r'[a-zA-Z0-9\-_]+@[a-zA-Z0-9]+\.[a-zA-Z0-9]{,3}', email) != None, emails))))
    
if __name__ == "__main__":
    solve()