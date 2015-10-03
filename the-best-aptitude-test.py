#!/usr/bin/env python3

import operator
import numpy as np

def main():
    T = int(input())
    for _ in range(T):
        N = int(input())
        GPAs = list(map(float, input().split()))
        aptitude_tests = [list(map(float, input().split())) for __ in range(5)]
        
        entries = filter(lambda entry: not np.isnan(entry[1]), map(lambda entry: (entry[0], np.corrcoef(GPAs, entry[1])[0, 1]), enumerate(aptitude_tests)))
        best_entry = max(entries, key=operator.itemgetter(1), default=(0, 0))
        print(best_entry[0] + 1)

if __name__ == "__main__":
    main()
