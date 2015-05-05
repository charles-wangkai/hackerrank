#!/usr/bin/env python3

import xml.etree.ElementTree as etree

def solve():
    line_num = int(input())
    xml = ''
    for i in range(line_num):
        xml += input() + '\n'
        
    tree = etree.ElementTree(etree.fromstring(xml))
    score = len(tree.getroot().attrib)
    for element in tree.findall('.//*'):
        score += len(element.attrib)
    
    print(score)
    
if __name__ == "__main__":
    solve()