from math import gcd
from functools import reduce

def get_gcd_of_list(lst):
    return reduce(lambda x, y: gcd(x, y), lst, 0)

def is_gcd_valid(lst, divisor):
    return divisor if all(elem % divisor for elem in lst) else 0

def solution(list_a, list_b):
    unique_a, unique_b = list(set(list_a)), list(set(list_b))
    
    gcd_b_a = is_gcd_valid(unique_a, get_gcd_of_list(unique_b))
    gcd_a_b = is_gcd_valid(unique_b, get_gcd_of_list(unique_a))
    
    return max(gcd_b_a, gcd_a_b) if gcd_b_a or gcd_a_b else 0
