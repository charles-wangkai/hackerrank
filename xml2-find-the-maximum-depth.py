#!/usr/bin/env python3

import xml.etree.ElementTree as etree

def find_depth(element):
    depth = 0
    for sub_element in element:
        depth = max(depth, 1 + find_depth(sub_element))
    return depth

def main():
    line_num = int(input())
    xml = ''
    for i in range(line_num):
        xml += input() + '\n'
        
    print(find_depth(etree.fromstring(xml)))
    
if __name__ == "__main__":
    main()
