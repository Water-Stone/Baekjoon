N = int(input())
list = [{} for _ in range(N)]
for i in range(N):
    ageandname = input().split(' ')
    list[i]['age'] = int(ageandname[0])
    list[i]['name'] = ageandname[1]

list.sort(key=lambda x: (x['age']))

for elem in list:
    print(f"{elem['age']} {elem['name']}")