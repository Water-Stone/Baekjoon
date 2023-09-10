def solution(board):
    if not board:
        return 0

    rows, cols = len(board), len(board[0])
    tmp = [[0] * cols for _ in range(rows)]

    for i in range(rows):
        tmp[i][0] = board[i][0]

    for i in range(cols):
        tmp[0][i] = board[0][i]

    for i in range(1, rows):
        for j in range(1, cols):
            if board[i][j] == 1:
                tmp[i][j] = min(tmp[i - 1][j - 1], tmp[i][j - 1], tmp[i - 1][j]) + 1

    return max(max(row) for row in tmp) ** 2
