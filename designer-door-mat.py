N, M = map(int, input().split())  # More than 6 lines of code will result in 0 score. Blank lines are not counted.
for i in range(1, N, 2): 
    print(('.|.' * i).center(M, '-'))  # Enter Code Here
print('WELCOME'.center(M, '-'))  # Enter Code Here
for i in range(N - 2, -1, -2): 
    print(('.|.' * i).center(M, '-'))  # Enter Code Here
