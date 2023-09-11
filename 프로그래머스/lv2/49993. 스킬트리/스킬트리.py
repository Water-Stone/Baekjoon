def solution(skill, skill_trees):
    answer = 0
    skill_list = list(skill)

    for skills in skill_trees:
        temp = []
        for s in skills:
            if s in skill_list:
                temp.append(s)

        if ''.join(temp) == skill[:len(temp)]:
            answer += 1

    return answer