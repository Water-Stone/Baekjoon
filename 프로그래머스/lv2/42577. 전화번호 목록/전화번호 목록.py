def solution(phone_book):
    if len(phone_book) == 1:
        return True
    
    pb = sorted(phone_book)
    
    for i, p in enumerate(pb):
        try:
            if pb[i+1][:len(p)] == p:
                return False
        except:
            break
    return True