from collections import deque

def solution(rows, columns, queries):
    board = []
    for i in range(rows):
        board.append([])
        for j in range(columns):
            board[i].append(columns * i + j + 1)
    
    result = []
    for query in queries:
        left_top_row = query[0] - 1
        left_top_col = query[1] - 1
        right_bot_row = query[2] - 1
        right_bot_col = query[3] - 1
        dq = deque()
        
        for i in range(left_top_col, right_bot_col + 1):
            dq.append(board[left_top_row][i])
        for i in range(left_top_row + 1, right_bot_row + 1):
            dq.append(board[i][right_bot_col])
        for i in range(right_bot_col - 1, left_top_col - 1, -1):
            dq.append(board[right_bot_row][i])
        for i in range(right_bot_row - 1, left_top_row, -1):
            dq.append(board[i][left_top_col])
        
        result.append(min(dq))
        dq.rotate(1)
        
        for i in range(left_top_col, right_bot_col + 1):
            board[left_top_row][i] = dq.popleft()
        for i in range(left_top_row + 1, right_bot_row + 1):
            board[i][right_bot_col] = dq.popleft()
        for i in range(right_bot_col - 1, left_top_col - 1, -1):
            board[right_bot_row][i] = dq.popleft()
        for i in range(right_bot_row - 1, left_top_row, -1):
            board[i][left_top_col] = dq.popleft()
    
    return result