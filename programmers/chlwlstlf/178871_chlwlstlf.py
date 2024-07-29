# 달리기 경주 (lv.1)

def solution(players, callings):
    dict = {}
    for i in range(len(players)):
        dict[players[i]] = i
        
    for call in callings:
        rank = dict[call]
        dict[call] -= 1
        dict[players[rank-1]] += 1
        
        players[rank], players[rank-1] = players[rank-1], players[rank]
        
    return players