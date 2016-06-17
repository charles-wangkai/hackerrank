#!/usr/bin/env python2.7

from collections import OrderedDict
import itertools
import sys

class MapReduce:
    def __init__(self):
        self.intermediate = OrderedDict()
        self.result = []

    def emitIntermediate(self, key, value):
        self.intermediate.setdefault(key, [])       
        self.intermediate[key].append(value)

    def emit(self, value):
        self.result[value[0]][value[1]] = value[2] 

    def execute(self, matrix1, matrix2, mapper, reducer):
        n = len(matrix1)
        m = len(matrix2[0])
        for i in xrange(0,n):
            self.result.append([0]*m)
        
        mapper(matrix1, matrix2)

        for key in self.intermediate:
            reducer(key, self.intermediate[key])

        for i in xrange(0,n):
            row = ""
            for j in xrange(0,m):
                 row += str(self.result[i][j]) + " "
            print row

mapReducer = None

def mapper(matrix1, matrix2):
    #Start writing the Map code here
    n = len(matrix1)
    k = len(matrix1[0])
    m = len(matrix2[0])
    
    for i in xrange(n):
        for j in xrange(m):
            for p in xrange(k):
                mapReducer.emitIntermediate((i, j), (matrix1[i][p], matrix2[p][j]))

def reducer(key, list_of_values):
    #Start writing the Reduce code here
    mapReducer.emit((key[0], key[1], sum(itertools.starmap(lambda x, y: x * y, list_of_values))))
    
if __name__ == '__main__':
    testcases = int(sys.stdin.readline().strip())
    for t in xrange(0,testcases):
        mapReducer = MapReduce()
        dimensions = sys.stdin.readline().strip().split(" ")
        row = int(dimensions[0])
        column = int(dimensions[1])
        matrix1 = []
        matrix2 = []
        for i in range(0, row):
            read_row = sys.stdin.readline().strip()
            matrix1.append([])
            row_elems = read_row.strip().split()
            for j in range(0, len(row_elems)):
                matrix1[i].append(int(row_elems[j]))
        dimensions = sys.stdin.readline().strip().split(" ")
        row = int(dimensions[0])
        column = int(dimensions[1])
        for i in range(0, row):
            read_row = sys.stdin.readline().strip()
            matrix2.append([])
            row_elems = read_row.strip().split()
            for j in range(0, len(row_elems)):
                matrix2[i].append(int(row_elems[j]))
        mapReducer.execute(matrix1, matrix2, mapper, reducer)
