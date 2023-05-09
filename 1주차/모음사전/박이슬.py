answer, cnt = 0, 0


def check(idx, s, word):
    global answer, cnt
    
    if s == word:
        answer = cnt
        return

    if idx == 5:
        return

    for v in ['A', 'E', 'I', 'O', 'U']:
        cnt += 1
        check(idx + 1, s + v, word)


def solution(word):
    check(0, '', word)
    return answer
