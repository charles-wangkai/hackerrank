#!/usr/bin/env python3

import re

def main():
    print("True" if re.fullmatch(r'(M{,3})?(D?C{,3}|CD|CM)?(L?X{,3}|XL|XC)?(V?I{,3}|IV|IX)?', input()) else "False")
    
if __name__ == "__main__":
    main()
