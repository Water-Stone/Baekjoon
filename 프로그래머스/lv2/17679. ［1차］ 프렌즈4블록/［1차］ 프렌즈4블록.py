def solution(m, n, board):
    # 블록 종류: R, M, A, F, N, T, J, C
    cnt_crushed = 0

    for i in range(m):
        board[i] = list(board[i])

    # 10
    # 00 -> 1의 위치만 탐색해서 4개 블록 뭉치 확인
    while True:
        crush_idx = [[False for _ in range(n)] for _ in range(m)]
        for i in range(m - 1):
            for j in range(n - 1):
                if board[i][j] == ' ':
                    continue
                b00 = board[i][j]
                b01 = board[i][j + 1]
                b10 = board[i + 1][j]
                b11 = board[i + 1][j + 1]
                if b00 == b01 and b00 == b10 and b00 == b11:
                    crush_idx[i][j] = True
                    crush_idx[i][j + 1] = True
                    crush_idx[i + 1][j] = True
                    crush_idx[i + 1][j + 1] = True

        tmpcnt = 0
        for i in range(m):
            tmpcnt += crush_idx[i].count(True)
            if tmpcnt == 0:
                if i == m - 1:
                    return cnt_crushed
        cnt_crushed += tmpcnt

        for i in range(m):
            for j in range(n):
                if crush_idx[i][j] == True:
                    if i == 0:
                        board[i][j] = ' '
                    else:
                        for level in range(i, 0, -1):
                            board[level][j] = board[level - 1][j]
                        board[0][j] = ' '