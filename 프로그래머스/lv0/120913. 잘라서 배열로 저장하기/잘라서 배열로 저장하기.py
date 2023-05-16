import re


def solution(my_str, n):
    return re.findall(f'.{{1,{n}}}', my_str)
