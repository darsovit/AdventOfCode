#!python
'''
Advent of Code 2015, Day 6
https://adventofcode.com/2015/day/6
'''

def readLines():
    with open('input.txt') as f:
        return f.readlines()

def sample():
    lines = [
        'turn on 0,0 through 999,999',
        'toggle 0,0 through 999,0',
        'turn off 499,499 through 500,500'
    ]
    return lines

def initializeField( lights ):
    for x in range(1000):
        for y in range(1000):
            lights[(x,y)] = 0

def turnOn( lights, corner1, corner2 ):
    for x in range(corner1[0],corner2[0]+1):
        for y in range( corner1[1],corner2[1]+1):
            lights[(x,y)] = 1

def turnOff( lights, corner1, corner2 ):
    for x in range(corner1[0],corner2[0]+1):
        for y in range(corner1[1],corner2[1]+1):
            lights[(x,y)] = 0

def toggle( lights, corner1, corner2 ):
    for x in range(corner1[0],corner2[0]+1):
        for y in range(corner1[1],corner2[1]+1):
            lights[(x,y)] ^= 1

def parseCorner(cornerString):
    (x,y) = map(int, cornerString.split(','))
    return (x,y)

def parseInstructions(lines, lights):
    for line in lines:
        instructions = line.rstrip().split()
        if instructions[0] == 'turn':
            corner1 = parseCorner(instructions[2])
            corner2 = parseCorner(instructions[4])
            command = turnOn if instructions[1] == 'on' else turnOff
        else:
            corner1 = parseCorner(instructions[1])
            corner2 = parseCorner(instructions[3])
            command = toggle
        command(lights, corner1, corner2)
    
def countLights(lights):
    count = 0
    for x in range(1000):
        for y in range(1000):
            count += 1 if lights[(x,y)] == 1 else 0
    return count

lights = {}
initializeField(lights)
parseInstructions(readLines(),lights)
print( countLights(lights) )