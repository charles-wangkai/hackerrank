#!/usr/bin/env python3

def is_valid(side_lengths):
    left_index = 0
    right_index = len(side_lengths) - 1
    prev_length = max(side_lengths[left_index], side_lengths[right_index])
    while left_index <= right_index:
        length = max(side_lengths[left_index], side_lengths[right_index])
        if length > prev_length:
            return False
        prev_length = length
        if side_lengths[left_index] == length:
            left_index += 1
        else:
            right_index -= 1
    return True

def main():
    T = int(input())
    
    for _ in range(T):
        n = int(input())
        side_lengths = list(map(int, input().split()))
        print('Yes' if is_valid(side_lengths) else 'No')

if __name__ == '__main__':
    main()
