#!/usr/bin/env python3

def main():
    S = input()
    
    print(*map(str.capitalize, S.split(sep=' ')), sep=' ')

if __name__ == "__main__":
    main()
