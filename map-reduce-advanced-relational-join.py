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
            print item

mapReducer = MapReduce()

def mapper(record):
    #Start writing the Map code here
    fields = record.replace('\n', '').split(',')
    
    if fields[0] == 'Employee':
        person_name = fields[1]
        ssn = fields[2]
        mapReducer.emitIntermediate(ssn, (fields[0], person_name))
    else:
        ssn = fields[1]
        department_name = fields[2]
        mapReducer.emitIntermediate(ssn, (fields[0], department_name))

def reducer(key, list_of_values):
    #Start writing the Reduce code here
    person_names = []
    department_names = []
    for label, value in list_of_values:
        if label == 'Employee':
            person_names.append(value)
        else:
            department_names.append(value)
    
    for person_name in person_names:
        for department_name in department_names:
            mapReducer.emit((key, person_name, department_name))
            
if __name__ == '__main__':
  inputData = []
  for line in sys.stdin:
   inputData.append(line)
  mapReducer.execute(inputData, mapper, reducer)
