#!/usr/bin/env python3

def main():
    n = int(input())
    
    words = []
    word2count = {}
    for _ in range(n):
        word = input()
        if word in word2count:
            word2count[word] += 1
        else:
            words.append(word)
            word2count[word] = 1
    
    print(len(words))
    print(*map(lambda word: word2count[word], words))

if __name__ == '__main__':
    main()
