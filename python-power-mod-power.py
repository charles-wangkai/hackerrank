#!/usr/bin/env python2.7

from __future__ import division

def main():
    a = int(raw_input())
    b = int(raw_input())
    m = int(raw_input())
    print a ** b
    print pow(a, b, m)

if __name__ == "__main__":
    main()
