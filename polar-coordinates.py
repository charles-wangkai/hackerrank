#!/usr/bin/env python3

import cmath

def main():
    z = complex(input())
    
    print(abs(z))
    print(cmath.phase(z))

if __name__ == "__main__":
    main()
