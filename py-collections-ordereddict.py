#!/usr/bin/env python3

import collections

def read_name_and_price():
    line = input()
    last_space_index = len(line) - 1 - line[::-1].index(' ')
    return line[:last_space_index], int(line[last_space_index + 1:])

def main():
    N = int(input())
    
    ordered_name2price = collections.OrderedDict()
    for _ in range(N):
        name, price = read_name_and_price()
        
        if name not in ordered_name2price:
            ordered_name2price[name] = 0
            
        ordered_name2price[name] += price
    
    for name in ordered_name2price:
        print(name, ordered_name2price[name])

if __name__ == '__main__':
    main()
