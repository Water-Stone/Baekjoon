def solution(N, number):
    # 사용할 숫자와 만들 수 있는 수를 저장하는 집합 생성
    dp = [set() for _ in range(9)]

    # 각 숫자를 사용하지 않은 경우 초기화
    for i in range(1, 9):
        dp[i].add(int(str(N) * i))

    # 사용한 숫자의 개수를 1부터 8까지 늘려가며 가능한 모든 조합 계산
    for i in range(1, 9):
        for j in range(1, i):
            for arg1 in dp[j]:
                for arg2 in dp[i - j]:
                    dp[i].add(arg1 + arg2)
                    dp[i].add(arg1 - arg2)
                    dp[i].add(arg1 * arg2)
                    if arg2 != 0:
                        dp[i].add(arg1 // arg2)

        # number와 일치하는 수를 찾아 사용한 횟수 반환
        if number in dp[i]:
            return i

    # 최솟값이 8보다 크면 -1 반환
    return -1
