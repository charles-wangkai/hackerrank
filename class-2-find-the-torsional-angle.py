#!/usr/bin/env python3

from math import *

class Point:
    def __init__(self, x, y, z):
        self.x = x
        self.y = y
        self.z = z
    
    def __sub__(self, other):
        return Point(self.x - other.x, self.y - other.y, self.z - other.z)
    
    def __mul__(self, other):
        return Point(self.y * other.z - self.z * other.y, self.z * other.x - self.x * other.z, self.x * other.y - self.y * other.x)
    
    def __abs__(self):
        return sqrt(self.x ** 2 + self.y ** 2 + self.z ** 2)
    
    @staticmethod
    def dot_product(a, b):
        return a.x * b.x + a.y * b.y + a.z * b.z;

def main():
    A = Point(*map(float, input().split()))
    B = Point(*map(float, input().split()))
    C = Point(*map(float, input().split()))
    D = Point(*map(float, input().split()))
    
    X = (B - A) * (C - B)
    Y = (C - B) * (D - C)
    torsional_angle = degrees(acos(Point.dot_product(X, Y) / abs(X) / abs(Y)))
    print('{0:.2f}'.format(torsional_angle))
    
if __name__ == '__main__':
    main()
