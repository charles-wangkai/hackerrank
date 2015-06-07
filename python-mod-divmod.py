#!/usr/bin/env python2.7

from __future__ import division

def main():
    a = int(raw_input())
    b = int(raw_input())
    print a // b
    print a % b
    print divmod(a, b)

if __name__ == "__main__":
    main()
