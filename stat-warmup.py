#!/usr/bin/env python3

import math
from scipy import stats
import numpy as np

def main():
    CONFIDENCE_INTERVAL_CONSTANT = 1.96
    
    N = int(input())
    numbers = np.array(list(map(int, input().split())))
    
    mean = np.mean(numbers)
    median = np.median(numbers)
    mode = stats.mode(numbers)[0][0]
    std = np.std(numbers)
    confidence_interval = [mean - CONFIDENCE_INTERVAL_CONSTANT * std / math.sqrt(len(numbers)), mean + CONFIDENCE_INTERVAL_CONSTANT * std / math.sqrt(len(numbers))]
    
    print('{mean:.1f}'.format(mean=mean))
    print('{median:.1f}'.format(median=median))
    print(mode)
    print('{std:.1f}'.format(std=std))
    print('{lower:.1f} {upper:.1f}'.format(lower=confidence_interval[0], upper=confidence_interval[1]))

if __name__ == '__main__':
    main()
