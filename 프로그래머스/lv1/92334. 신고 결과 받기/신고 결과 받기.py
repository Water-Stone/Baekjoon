def solution(id_list, report, k):
    result = [0] * len(id_list)
    report_stacks = [{} for _ in range(len(id_list))]
    # for _ in range(len(id_list)):
    #     report_stacks.append({})
    valid_stacks = [0] * len(id_list)
    
    for rep in report:
        reporter = rep.split(' ')[0]
        bereported = rep.split(' ')[1]
        idx = id_list.index(reporter)
        if bereported in report_stacks[idx]:
            report_stacks[idx][bereported] += 1
        else:
            report_stacks[idx][bereported] = 1
            # 동일인 중복 신고 제외, 유효 신고 누적
            valid_stacks[id_list.index(bereported)] += 1
    
    for i in range(len(valid_stacks)):
        if valid_stacks[i] >= k:
            for j in range(len(id_list)):
                if report_stacks[j].get(id_list[i]) != None:
                    result[j] += 1
    
    return result