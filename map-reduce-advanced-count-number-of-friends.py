#!/usr/bin/env python2.7

from collections import OrderedDict
import sys


class MapReduce:
    def __init__(self):
        self.intermediate = OrderedDict()
        self.result = []
   

    def emitIntermediate(self, key, value):
        self.intermediate.setdefault(key, [])       
        self.intermediate[key].append(value)

    def emit(self, value):
        self.result.append(value) 

    def execute(self, data, mapper, reducer):
        for record in data:
            mapper(record)

        for key in self.intermediate:
            reducer(key, self.intermediate[key])

        self.result.sort()
        for item in self.result:
            print "{\"key\":\""+item[0]+"\",\"value\":\"" + str(item[1]) + "\"}"

mapReducer = MapReduce()

def mapper(record):
    #Start writing the Map code here
    friend1, friend2 = record.replace('\n', '').split(' ')
    mapReducer.emitIntermediate(friend1, friend2)
    mapReducer.emitIntermediate(friend2, friend1)

def reducer(key, list_of_values):
    #Start writing the Reduce code here
    mapReducer.emit((key, len(set(list_of_values))))
    
if __name__ == '__main__':
  inputData = []
  for line in sys.stdin:
   inputData.append(line)
  mapReducer.execute(inputData, mapper, reducer)
