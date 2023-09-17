def solution(n):
    def back_tracking(row, col_mask, diag_mask, anti_diag_mask):
        if row == n:
            return 1

        count = 0
        available_positions = ((1 << n) - 1) & (~(col_mask | diag_mask | anti_diag_mask))

        while available_positions:
            position = available_positions & -available_positions
            available_positions -= position
            col = bin(position - 1).count('1')

            new_col_mask = col_mask | (1 << col)
            new_diag_mask = (diag_mask | position) >> 1
            new_anti_diag_mask = (anti_diag_mask | position) << 1

            count += back_tracking(row + 1, new_col_mask, new_diag_mask, new_anti_diag_mask)

        return count

    return back_tracking(0, 0, 0, 0)
