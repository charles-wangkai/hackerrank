#!/usr/bin/env python3

# http://scikit-learn.org/stable/modules/linear_model.html#polynomial-regression-extending-linear-models-with-basis-functions

from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import PolynomialFeatures
import numpy as np

def main():
    F, N = map(int, input().split())
    featuresList = []
    targets = []
    for _ in range(N):
        fields = list(map(float, input().split()))
        featuresList.append(fields[:-1])
        targets.append(fields[-1])
     
    poly = PolynomialFeatures(degree=3)

    regression = LinearRegression()
    regression.fit(poly.fit_transform(np.array(featuresList)), targets)
    
    T = int(input())
    for _ in range(T):
        features = list(map(float, input().split()))
        print(regression.predict(poly.fit_transform(np.array(features)))[0])

if __name__ == '__main__':
    main()
