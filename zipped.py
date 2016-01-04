#!/usr/bin/env python3

import statistics

def main():
    N, X = map(int, input().split())
    subjects = [map(float, input().split()) for _ in range(X)]
    
    print(*map(lambda student: '{0:.1f}'.format(statistics.mean(student)), zip(*subjects)), sep='\n')

if __name__ == "__main__":
    main()
