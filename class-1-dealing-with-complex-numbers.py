#!/usr/bin/env python3

from math import sqrt

class Complex:
    def __init__(self, real, imaginary):
        self.real = real
        self.imaginary = imaginary
    
    def __add__(self, other):
        return Complex(self.real + other.real, self.imaginary + other.imaginary)
    
    def __sub__(self, other):
        return Complex(self.real - other.real, self.imaginary - other.imaginary)
    
    def __mul__(self, other):
        return Complex(self.real * other.real - self.imaginary * other.imaginary, self.real * other.imaginary + self.imaginary * other.real)
    
    def __truediv__(self, other):
        other_square_abs = other.real ** 2 + other.imaginary ** 2
        return Complex((self.real * other.real + self.imaginary * other.imaginary) / other_square_abs, (-self.real * other.imaginary + self.imaginary * other.real) / other_square_abs)
    
    def __abs__(self):
        return Complex(sqrt(self.real ** 2 + self.imaginary ** 2), 0)
    
    def __str__(self):
        real_part = '' if self.real == 0 and self.imaginary != 0 else '{0:.2f}'.format(self.real)
        sign = '' if real_part == '' else '+' if self.imaginary > 0 else '-' if self.imaginary < 0 else ''
        imaginary_part = '{0:.2f}i'.format(self.imaginary if real_part == '' else abs(self.imaginary)) if self.imaginary != 0 else ''
        return '{real_part} {sign} {imaginary_part}'.format(real_part=real_part, sign=sign, imaginary_part=imaginary_part).strip()

def main():
    C = Complex(*map(float, input().split()))
    D = Complex(*map(float, input().split()))
    
    print(C + D)
    print(C - D)
    print(C * D)
    print(C / D)
    print(abs(C))
    print(abs(D))
    
if __name__ == '__main__':
    main()
