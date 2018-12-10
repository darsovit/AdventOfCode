#!python
'''
Advent of Code 2015, Day 10
https://adventofcode.com/2015/day/10
'''

def lookAndSay(input):
    currentChar = None
    currentCount = 0
    output = []
    for char in list(input):
        if char != currentChar:
            if currentCount > 0:
                output += [ str(currentCount), currentChar ]
            currentChar = char
            currentCount = 1
        else:
            currentCount += 1
    if currentCount > 0 and currentChar:
        output += [ str(currentCount), currentChar ]
    return ''.join(output)

input = '1321131112'

for i in range(50):
    input = lookAndSay(input)
    print( input, i )
    
print(input, len(input))

# 261050 is too low?