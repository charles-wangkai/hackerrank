#!/usr/bin/env python3

import collections

def main():
    S = input()
    
    for item in sorted(collections.Counter(S).items(), key=lambda item: (-item[1], item[0]))[:3]:
        print(*item)

if __name__ == '__main__':
    main()
