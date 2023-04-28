# dictionary {key = '점수', value = '문제 번호'}
scores = {}
for q in range(8):
    scores[int(input())] = (q + 1)

topFive = list(scores.keys())
topFive.sort(reverse = True)
del topFive[5:]

totalScore = 0
for scr in topFive:
    totalScore += scr

qnList = []
for key in topFive:
    qnList.append(scores.get(key))
qnList.sort()

print(totalScore)
print(*qnList)