#!/usr/bin/env python3

def print_path(half_size, move1, move2):
    for _ in range(half_size):
        print(move1)
    for _ in range(half_size):
        print(move2)

def main():
    N = int(input())
    grid = [input() for _ in range(N)]
    
    half_size = N // 2
    if grid[0][0] == 'p':
        print_path(half_size, 'LEFT', 'UP')
    elif grid[0][N - 1] == 'p':
        print_path(half_size, 'RIGHT', 'UP')
    elif grid[N - 1][0] == 'p':
        print_path(half_size, 'LEFT', 'DOWN')
    else:
        print_path(half_size, 'RIGHT', 'DOWN')

if __name__ == '__main__':
    main()
