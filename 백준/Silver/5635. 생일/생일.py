def isYoungest(_youngest, _contender):
    # year
    y_year = int(_youngest.split()[3])
    c_year = int(_contender.split()[3])
    if  c_year >= y_year:
        if c_year > y_year:
            return True
        else:
            # month
            y_month = int(_youngest.split()[2])
            c_month = int(_contender.split()[2])
            if c_month >= y_month:
                if c_month > y_month:
                    return True
                else:
                    # day
                    y_day = int(_youngest.split()[1])
                    c_day = int(_contender.split()[1])
                    if c_day > y_day:
                        # 생일이 같은 사람은 없다.
                        return True
    return False

def isOldest(_oldest, _contender):
    # year
    o_year = int(_oldest.split()[3])
    c_year = int(_contender.split()[3])
    if c_year <= o_year:
        if c_year < o_year:
            return True
        else:
            # month
            o_month = int(_oldest.split()[2])
            c_month = int(_contender.split()[2])
            if c_month <= o_month:
                if c_month < o_month:
                    return True
                else:
                    # day
                    o_day = int(_oldest.split()[1])
                    c_day = int(_contender.split()[1])
                    if c_day < o_day:
                        # 생일이 같은 사람은 없다.
                        return True
    return False

headcount = int(input())

# split -> name, day, month, year
youngest = oldest = input()
for i in range(1, headcount):
    curr = input()
    if isYoungest(youngest, curr):
        youngest = curr
    elif isOldest(oldest, curr):
        oldest = curr

print(youngest.split()[0])
print(oldest.split()[0])