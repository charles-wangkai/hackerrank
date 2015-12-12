#!/usr/bin/env python3

def main():
    import collections, statistics
    N = int(input())
    Student = collections.namedtuple('Student', input().split())
    print('{0:.2f}'.format(statistics.mean(map(lambda student: float(student.MARKS), [Student._make(input().split()) for _ in range(N)]))))

if __name__ == '__main__':
    main()
