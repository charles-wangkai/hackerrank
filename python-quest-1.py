#!/usr/bin/env python3

def main():
    for i in range(1, int(input())):  # More than 2 lines will result in 0 score. Do not leave a blank line also
        print((10 ** i - 1) // 9 * i)

if __name__ == '__main__':
    main()
