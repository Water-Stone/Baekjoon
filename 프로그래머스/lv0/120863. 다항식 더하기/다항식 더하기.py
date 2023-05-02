def solution(polynomial):
    x_cnt = 0
    cons_num = 0
    plist = polynomial.replace(' ', '').split('+')
    for term in plist:
        idx = term.find('x')
        if idx == -1:
            # 상수항
            cons_num += int(term)
        elif idx == 0:
            # 1x
            x_cnt += 1
        else:
            # nx
            x_cnt += int(term.strip()[0:idx])
    
    result = ''
    if x_cnt != 0:
        if x_cnt == 1:
            result += 'x + '
        else:
            result += f'{x_cnt}x + '
    
    if cons_num != 0:
        result += f'{cons_num}'
    elif x_cnt == 0:
        result = '0'
    else:
        result = result[:result.find('x') + 1]
    
    return result.strip()