#!/usr/bin/env python3

def search(grid, target):
    for r in range(5):
        for c in range(5):
            if grid[r][c] == target:
                return r, c

def main():
    bot_r, bot_c = map(int, input().split())
    grid = [input() for _ in range(5)]
    
    if grid[bot_r][bot_c] == 'd':
        print('CLEAN')
    else:
        dirty_r, dirty_c = search(grid, 'd')
        
        if dirty_r < bot_r:
            print('UP')
        elif dirty_r > bot_r:
            print('DOWN')
        elif dirty_c < bot_c:
            print('LEFT')
        else:
            print('RIGHT')

if __name__ == '__main__':
    main()
