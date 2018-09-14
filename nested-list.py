#!/usr/bin/env python3

def main():
    N = int(input())
    students = []
    for i in range(N):
        name = input()
        mark = float(input())
        students.append([name, mark])
    
    students.sort(key=lambda student: (student[1], student[0]))
    
    second_lowest_mark = [student[1] for student in students if student[1] != students[0][1]][0]
    for s in [student for student in students if student[1] == second_lowest_mark]:
        print(s[0])
    
if __name__ == '__main__':
    main()
