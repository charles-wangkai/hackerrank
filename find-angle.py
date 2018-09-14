#!/usr/bin/env python2.7
# -*- coding: utf-8 -*-

import math

def main():
    AB = int(input())
    BC = int(input())
    
    theta = round(math.degrees(math.asin(AB / math.sqrt(AB ** 2 + BC ** 2))))
    print '{theta:.0f}°'.format(theta=theta)

if __name__ == '__main__':
    main()
