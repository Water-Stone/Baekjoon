def solution(clothes):
    clothes_obj = {}
    
    for cloth, cloth_type in clothes:
        if cloth_type not in clothes_obj:
            clothes_obj[cloth_type] = 1
        else:
            clothes_obj[cloth_type] += 1
    
    clothes_count = 1
    for cloth_type_count in clothes_obj.values():
        clothes_count *= (cloth_type_count + 1)
    
    # Subtract 1 to exclude the case of not wearing any clothes
    answer = clothes_count - 1
    return answer
