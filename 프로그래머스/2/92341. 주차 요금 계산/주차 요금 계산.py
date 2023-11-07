import math


def timediff(t1, t2):
    h1, m1 = map(int, t1.split(':'))
    h2, m2 = map(int, t2.split(':'))

    minutes1 = h1 * 60 + m1
    minutes2 = h2 * 60 + m2

    return abs(minutes1 - minutes2)

def solution(fees, records):
    def get_fee(totaltime):
        if totaltime <= fees[0]:
            return fees[1]
        return fees[1] + math.ceil((totaltime - fees[0]) / fees[2]) * fees[3]
    
    rd = {}
    carnums = []
    parked_cars = set()
    
    for record in records:
        time, carnum, action = record.split()
        if carnum not in carnums:
            carnums.append(carnum)
        if action == 'IN':
            parked_cars.add(carnum)
            if carnum not in rd:
                rd[carnum] = {'intime':'', 'totaltime':0}
            rd[carnum]['intime'] = time
        elif action == 'OUT':
            parked_cars.discard(carnum)
            rd[carnum]['totaltime'] += timediff(rd[carnum]['intime'], time)
    
    while parked_cars:
        carnum = parked_cars.pop()
        rd[carnum]['totaltime'] += timediff(rd[carnum]['intime'], '23:59')
    
    carnums.sort(key=lambda x: int(x))
    return [get_fee(rd[carnum]['totaltime']) for carnum in carnums]