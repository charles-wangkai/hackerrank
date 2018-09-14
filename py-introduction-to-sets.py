#!/usr/bin/env python3

def main():
    height_num = int(input())
    distinct_heights = set(map(int, input().split()))
    
    print(sum(distinct_heights) / len(distinct_heights))

if __name__ == '__main__':
    main()
