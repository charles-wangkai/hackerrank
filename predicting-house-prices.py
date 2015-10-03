#!/usr/bin/env python3

# http://scikit-learn.org/stable/modules/generated/sklearn.linear_model.LinearRegression.html

from sklearn.linear_model import LinearRegression

def main():
    F, N = map(int, input().split())
    featuresList = []
    targets = []
    for _ in range(N):
        fields = list(map(float, input().split()))
        featuresList.append(fields[:-1])
        targets.append(fields[-1])
     
    regression = LinearRegression()
    regression.fit(featuresList, targets)
    
    T = int(input())
    for _ in range(T):
        features = list(map(float, input().split()))
        print(regression.predict(features)[0])

if __name__ == "__main__":
    main()
