#!/usr/bin/env python3

def main():
    N = int(input())
    fibonacci = []
    for i in range(N):
        fibonacci.append(i if i < 2 else fibonacci[i - 2] + fibonacci[i - 1])
    
    print(list(map(lambda x: x ** 3, fibonacci)))
    
if __name__ == '__main__':
    main()
