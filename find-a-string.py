#!/usr/bin/env python3

def main():
    string = input()
    substring = input()
    
    occurrence = 0
    start = 0
    while True:
        index = string.find(substring, start)
        if index < 0:
            break
        occurrence += 1
        start = index + 1
        
    print(occurrence)
    
if __name__ == '__main__':
    main()