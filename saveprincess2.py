#!/usr/bin/env python3

def search(grid, target):
    size = len(grid)
    for r in range(size):
        for c in range(size):
            if grid[r][c] == target:
                return r, c

def main():
    N = int(input())
    bot_r, bot_c = map(int, input().split())
    grid = [input() for _ in range(N)]
    
    princess_r, princess_c = search(grid, 'p')
    if princess_r < bot_r:
        print('UP')
    elif princess_r > bot_r:
        print('DOWN')
    elif princess_c < bot_c:
        print('LEFT')
    else:
        print('RIGHT')

if __name__ == "__main__":
    main()
