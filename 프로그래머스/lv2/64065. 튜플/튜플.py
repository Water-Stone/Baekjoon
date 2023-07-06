def solution(s):
    s = s.strip()
    stack = []
    slist = []
    result = []
    
    moa = ''
    for c in s:
        if c.isdigit():
            moa += c
        elif c == '}' and moa:
            stack.append(int(moa))
            moa = ''
            slist.append(set(stack))
            stack.clear()
        elif c == ',' and moa:
            stack.append(int(moa))
            moa = ''
    
    slist.sort(key= lambda x: len(x))
    for curr_set in slist:
        while curr_set:
            num = curr_set.pop()
            if num not in result:
                result.append(num)
    return result