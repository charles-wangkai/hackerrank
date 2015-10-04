#!/usr/bin/env python3

def main():
    bot_r, bot_c = map(int, input().split())
    grid = [input() for _ in range(5)]
    
    if grid[bot_r][bot_c] == 'd':
        print('CLEAN')
    else:
        dirty_cells = filter(lambda cell:grid[cell[0]][cell[1]] == 'd', [(r, c) for c in range(5) for r in range(5)])
        nearest_cell = min(dirty_cells, key=lambda cell:abs(bot_r - cell[0]) + abs(bot_c - cell[1]))
        
        if nearest_cell[0] < bot_r:
            print('UP')
        elif nearest_cell[0] > bot_r:
            print('DOWN')
        elif nearest_cell[1] < bot_c:
            print('LEFT')
        else:
            print('RIGHT')

if __name__ == "__main__":
    main()
