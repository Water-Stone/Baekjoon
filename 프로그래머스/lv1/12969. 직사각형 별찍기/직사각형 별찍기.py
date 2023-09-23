a, b = map(int, input().strip().split(' '))
result = ''
for i in range(b):
    for j in range(a):
        result += '*'
    result += '\n'
print(result[:-1])