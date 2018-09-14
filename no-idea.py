#!/usr/bin/env python3

import collections

def read_line_as_int_list():
    return map(int, input().split())

def compute_sum_in_set(number2count, s):
    return sum(map(lambda number: number2count[number] if number in s else 0, number2count))

def main():
    n, m = read_line_as_int_list()
    
    number2count = collections.defaultdict(int)
    for number in read_line_as_int_list():
        number2count[number] += 1
    
    A = set(read_line_as_int_list())
    B = set(read_line_as_int_list())
    
    print(compute_sum_in_set(number2count, A) - compute_sum_in_set(number2count, B))

if __name__ == '__main__':
    main()
