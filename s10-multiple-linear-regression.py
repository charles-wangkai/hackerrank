#!/usr/bin/env python3

from sklearn import linear_model
import numpy as np

def main():
    m, n = map(int, input().split())
    
    x = []
    y = []
    for _ in range(n):
        fields = input().split()
        x.append(list(map(float, fields[:-1])))
        y.append(float(fields[-1]))
    
    lm = linear_model.LinearRegression()
    lm.fit(x, y)
    
    q = int(input())
    for _ in range(q):
        predict_x = list(map(float, input().split()))
        print(lm.predict(np.asarray(predict_x).reshape(1, -1))[0])
    
if __name__ == '__main__':
    main()
