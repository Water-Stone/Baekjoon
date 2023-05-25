# import re

# def solution(s):
#     p = re.compile(r'([a-z]+)\1+')
#     if p.match(s):
#         s = p.sub(f'X{"-" * len(p.search(s).group(1))}', s)
#         # while p.search(s):
#         #     m = p.search(s).group()
#         #     s = s.replace(m, f'{len(m)}{m[:1]}')
#     return len(s)

def solution(s):
    answer = 1001
    n = len(s)
    # 테스트케이스 5번 : 문자열 s의 길이가 1일때 처리 
    if n == 1:
        return 1
    for unit in range(1, n//2+1):
        # print('unit=', unit)
        compress = ""
        pre = s[0:unit]
        # print('pre',pre)
        count = 1
        # 단위(unit)만큼 크기 증가시켜 비교
        for i in range(unit, n, unit):
            if pre == s[i:i+unit]:
                # print('yes')
                count += 1
            else:
                # 중복 카운팅이 2이상인 경우에만 숫자 포함 
                compress += str(count) + pre if count >= 2 else pre 
                pre = s[i:i+unit]
                count = 1
                # print('compress', compress, end = ' ')
                # print('pre',pre)
        # else 문에 걸리지 않아 compress에 포함되지 않은 문자열 처리 
        compress += str(count) + pre if count >= 2 else pre
        # print('compress', compress)
        answer = min(answer, len(compress))
    return answer