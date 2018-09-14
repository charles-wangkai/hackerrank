#!/usr/bin/env python3

def main():
    x = float(input())
    y = float(input())
    
    print("{0:.2f}".format(x + y))
    print("{0:.2f}".format(x - y))
    print("{0:.2f}".format(x * y))
    print("{0:.2f}".format(x / y))
    print("{0:.2f}".format(x // y))
    
if __name__ == '__main__':
    main()
