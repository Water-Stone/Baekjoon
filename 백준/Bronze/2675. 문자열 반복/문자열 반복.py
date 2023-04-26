T = int(input())
times=[]
text=[]
results=[]
for i in range(T):
    case = input().split()
    times.append(int(case[0]))
    text.append(case[1])
    results.append('')

for i in range(T):
    for j in range(len(text[i])):
        for k in range(times[i]):
            results[i] += text[i][j]

for i in range(T):
    print(results[i])