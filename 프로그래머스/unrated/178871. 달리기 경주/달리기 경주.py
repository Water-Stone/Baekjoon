def solution(players, callings):
    players_dict = {}
    ranks_dict = {}
    for idx, player in enumerate(players):
        players_dict[player] = idx
        ranks_dict[idx] = player
    
    for call in callings:
        cur = players_dict[call]
        losing_player = ranks_dict[cur - 1]
        ranks_dict[cur], ranks_dict[players_dict[losing_player]] = losing_player, call
        players_dict[call] -= 1
        players_dict[losing_player] += 1
    return list(ranks_dict.values())