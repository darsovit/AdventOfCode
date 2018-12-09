#!python
'''
Advent of Code 2015, Day 8, Part 2
https://adventofcode.com/2015/day/8
'''

def encode_for_program(line):
    encoded_str = [ '\"' ]
    for char in list(line):
        if char == '\"':
            encoded_str += list("\\\"")
        elif char == '\\':
            encoded_str += list("\\\\")
        else:
            encoded_str += [ char ]
    encoded_str += [ '\"' ]
    return ''.join(encoded_str)

code_size = 0
encoded_size = 0
with open('input.txt') as f:
    for line in map(str.rstrip, f):
        code_size += len(line)
        encoded_size += len(encode_for_program(line))
        
print( encoded_size )
print( code_size )
print( encoded_size - code_size )