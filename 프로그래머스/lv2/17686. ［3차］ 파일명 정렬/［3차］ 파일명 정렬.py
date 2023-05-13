def solution(files):
    answer = []
    file_dicts = [{
        'og_text': f'{file}', 'input_idx': files.index(file),
        'head': '', 'number': '', 'tail': ''} for file in files]

    for elem in file_dicts:
        name = elem['og_text']
        head = ''
        number = ''
        for i in range(len(name)):
            if name[i].isdigit():
                for j in range(i, i + 5):
                    if j < len(name):
                        if not name[j].isdigit():
                            elem['tail'] = name[j:]
                            break
                        number += name[j]
                    else:
                        break
                elem['number'] = int(number)
                break
            head += name[i]
        elem['head'] = head.lower()

    answer = list(map(lambda elem: elem['og_text'],
                      sorted(file_dicts, key=lambda elem:
                             (elem['head'], elem['number'], elem['input_idx']))))

    return answer