#!/usr/bin/env python3

def main():
    n = int(input())
    
    print('Weird' if (n % 2 == 1 or (n % 2 == 0 and 6 <= n <= 20)) else 'Not Weird')

if __name__ == '__main__':
    main()
