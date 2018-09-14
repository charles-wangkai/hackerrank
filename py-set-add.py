#!/usr/bin/env python3

def main():
    N = int(input())
    distinct_countries = set()
    
    for _ in range(N):
        country = input()
        distinct_countries.add(country)
    
    print(len(distinct_countries))

if __name__ == '__main__':
    main()
