#!python
'''
Advent of Code 2015, Day 8, Part 1
https://adventofcode.com/2015/day/8
'''

code_size = 0
text_size = 0

def parse_text(line):
    state = None
    text_line = []
    hex_code = []
    for char in list(line):
        if not state:
            state = 1 if char == '"' else -1
        elif state == 1:
            if char == '\\':
                state = 2
            elif char == '"':
                state = 10
            else:
                text_line += [ char ]
        elif state == 2:
            if char == '\\':
                text_line += [ '\\' ]
                state = 1
            elif char == '"':
                text_line += [ '"' ]
                state = 1
            elif char == 'x':
                state = 3
            else:
                state = -1
        elif state == 3:
            hex_code += char
            state = 4
        elif state == 4:
            hex_code += char
            text_line += [ chr(int(''.join(hex_code), 16)) ]
            state = 1
            hex_code = []
        elif state == 10:
            state = -1
    if state == 10:
        return ''.join(text_line)
    else:
        return None
            
       
with open('input.txt') as f:
    for line in map(str.rstrip, f):
        code_size += len(line)
        text_size += len(parse_text(line))
print( 'code_size', code_size )
print( 'text_size', text_size )
print( 'diff', code_size - text_size )