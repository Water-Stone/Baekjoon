def solution(n):
    count = 0
    # 연속된 수들로 표현하기 위해 시작점을 1로 설정
    start = 1
    
    # 시작점부터 연속된 수들을 더해가며 n을 만들 수 있는지 확인
    while start <= n:
        total = 0
        num = start
        
        # 연속된 수들을 더해가며 합을 계산
        while total < n:
            total += num
            num += 1
            
        # 합이 n과 같으면 count 증가
        if total == n:
            count += 1
        
        # 다음 시작점으로 이동
        start += 1
        
    return count
 