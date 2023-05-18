import re


def time_diff_minutes(start, end):
    result = (int(end.split(':')[0]) - int(start.split(':')[0])) *\
        60 + (int(end.split(':')[1]) - int(start.split(':')[1]))

    return result


def solution(m, musicinfos):
    # C, C#, D, D#, E, F, F#, G, G#, A, A#, B
    pattern = re.compile(r'[CDFGA]#?|[EB]')

    matched_musics = {}

    regex_nosharp = ''
    tmplist = pattern.findall(m)
    for i in range(len(tmplist)):
        regex_nosharp += tmplist[i]
        regex_nosharp += '(?!#)'

    for music in musicinfos:
        info = music.split(',')
        playtime = time_diff_minutes(info[0], info[1])
        title = info[2]
        melody = pattern.findall(info[3])

        replays, partplays = divmod(playtime, len(melody))
        played = melody * replays + melody[:partplays]

        if re.search(regex_nosharp, ''.join(played)):
            matched_musics[title] = playtime

    if matched_musics:
        return max(matched_musics.keys(), key=lambda x: matched_musics[x])
    else:
        return '(None)'