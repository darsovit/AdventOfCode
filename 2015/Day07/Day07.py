#!python
'''
Advent of Code 2015, Day 7, Part 1
https://adventofcode.com/2015/day/7
'''

def readStrippedInput():
    with open('input.txt') as f:
        return list(map(str.rstrip, f.readlines()))

def oneComplement( someValue ):
    return ( ~someValue & 0xffff )

def value(circuit, valueOf):
    if valueOf in circuit['cache']:
        return circuit['cache'][valueOf]
    if valueOf in circuit:
        (func, inputs) = circuit[valueOf]
        circuit['cache'][valueOf] = func(circuit,inputs)
        return circuit['cache'][valueOf]
    else:
        return int(valueOf)

def bitwiseNot(circuit, valueOf):
    return oneComplement( value( circuit, valueOf ) )

def bitwiseOr(circuit, valueOf):
    return value(circuit,valueOf[0]) | value(circuit,valueOf[1])
    
def bitwiseAnd(circuit, valueOf):
    return value(circuit,valueOf[0]) & value(circuit,valueOf[1])

def leftShift(circuit, valueOf):
    return ( value(circuit,valueOf[0]) << value(circuit,valueOf[1]) ) & 0xffff

def rightShift(circuit, valueOf):
    return value(circuit,valueOf[0]) >> value(circuit,valueOf[1])

def getCmd(command):
    if command == 'OR':
        return bitwiseOr
    elif command == 'LSHIFT':
        return leftShift
    elif command == 'RSHIFT':
        return rightShift
    elif command == 'AND':
        return bitwiseAnd
    else:
        return None

def parseCircuit(lines):
    circuit = {}
    circuit['cache'] = {}
    for line in lines:
        splitLine = line.split()
        target = splitLine[-1]
        print(target)
        sourceCmds = splitLine[:-2]
        if len(sourceCmds) == 1:
            circuit[target] = (value, sourceCmds[0])
        elif len(sourceCmds) == 2:
            circuit[target] = (bitwiseNot, sourceCmds[1])
        else:
            circuit[target] = (getCmd(sourceCmds[1]), (sourceCmds[0],sourceCmds[2]))

    return circuit

circuit = parseCircuit(readStrippedInput())
print( value(circuit, 'a') )
