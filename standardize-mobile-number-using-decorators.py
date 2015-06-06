#!/usr/bin/env python3

def standardize_wrapper(func):
    def standardize(mobile_number):
        return "{prefix} {left} {right}".format(prefix='+91', left=mobile_number[-10:-5], right=mobile_number[-5:])
    
    def wrap(mobile_numbers):
        return func(map(standardize, mobile_numbers))
    
    return wrap

def main():
    N = int(input())
    mobile_numbers = [input() for i in range(N)]
    
    standardized_sort = standardize_wrapper(sorted)
    
    for mobile_number in standardized_sort(mobile_numbers):
        print(mobile_number)
    
if __name__ == "__main__":
    main()
