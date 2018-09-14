#!/usr/bin/env python3

def is_vowel(letter):
    return letter in 'AEIOU'

def compute_score(S, letter_condition):
    return sum(map(lambda entry: len(S) - entry[0], filter(lambda entry: letter_condition(entry[1]), enumerate(S))))

def main():
    S = input()
    
    stuart_score = compute_score(S, lambda letter: not is_vowel(letter))
    kevin_score = compute_score(S, is_vowel)
    
    if stuart_score > kevin_score:
        print('Stuart', stuart_score)
    elif stuart_score < kevin_score:
        print('Kevin', kevin_score)
    else:
        print('Draw')

if __name__ == '__main__':
    main()
