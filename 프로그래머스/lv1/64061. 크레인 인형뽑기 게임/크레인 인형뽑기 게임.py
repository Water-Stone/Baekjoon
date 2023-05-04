# 크레인 인형뽑기 게임
def solution(board, moves):
    result = 0
    basket = [0]

    for move in moves:
        for level in range(len(board)):
            if not board[level][move - 1] == 0:
                if basket[-1] == board[level][move - 1]:
                    basket.pop()
                    result += 2
                else:
                    basket.append(board[level][move - 1])

                board[level][move - 1] = 0
                break

    return result