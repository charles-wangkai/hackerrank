#!/usr/bin/env python3
from operator import itemgetter

def sexualize_wrapper(func):
    def standardize(mobile_number):
        return "{prefix} {left} {right}".format(prefix='+91', left=mobile_number[-10:-5], right=mobile_number[-5:])
    
    def wrap(person):
        func('{title} {firstname} {lastname}'.format(title='Mr.' if person[3] == 'M' else 'Ms.', firstname=person[0], lastname=person[1]))
    
    return wrap

def solve():
    N = int(input())
    people = [input().split() for i in range(N)]
    
    sexualized_print = sexualize_wrapper(print)
    for person in sorted(people, key=itemgetter(2)):
        sexualized_print(person)
    
if __name__ == "__main__":
    solve()
