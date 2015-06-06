#!/usr/bin/env python3

import re

def main():
    N = int(input())
    for i in range(N):
        print("YES" if re.fullmatch(r'[789]\d{9}', input()) else "NO")
    
if __name__ == "__main__":
    main()
