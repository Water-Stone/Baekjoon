def solution(board, h, w):
    n = len(board)
    color = board[h][w]
    result = 0
    
    if h != 0:
        if color == board[h - 1][w]:
            result += 1
    
    if w != 0:
        if color == board[h][w - 1]:
            result += 1
    
    if h != n - 1:
        if color == board[h + 1][w]:
            result += 1
    
    if w != n - 1:
        if color == board[h][w + 1]:
            result += 1

    return result