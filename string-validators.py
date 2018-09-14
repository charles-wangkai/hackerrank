#!/usr/bin/env python3

def main():
    S = input()
    
    print(any(map(str.isalnum, S)))
    print(any(map(str.isalpha, S)))
    print(any(map(str.isdigit, S)))
    print(any(map(str.islower, S)))
    print(any(map(str.isupper, S)))

if __name__ == '__main__':
    main()
