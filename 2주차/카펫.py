def solution(brown, yellow):
    total = brown + yellow
    for a in range(1, total):
        if total % a == 0:
            b = total // a
            if 2 * (a + b) - 4 == brown:
                return [b, a]
