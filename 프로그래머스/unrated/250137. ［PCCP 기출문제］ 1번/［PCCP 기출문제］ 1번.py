def solution(bandage, health, attacks):
    band_time, heal_for_sec, add_heal = bandage
    MAX_HP = health
    cur_time = 0
    for atk_time, dmg in attacks:
        safe_time = atk_time - cur_time - 1
        cur_time = atk_time
        
        health += safe_time * heal_for_sec
        combo = safe_time // band_time
        if combo:
            health += combo * add_heal
        if health > MAX_HP:
            health = MAX_HP
        
        health -= dmg
        if health <= 0:
            return -1
    return health
        
        