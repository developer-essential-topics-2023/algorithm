from itertools import combinations
from collections import defaultdict


def solution(orders, course):
    answer = []
    for c in course:
        cnt = defaultdict(int)
        for order in orders:
            for com in combinations(order, c):
                com = ''.join(sorted(com))
                cnt[com] += 1
        answer.extend([k for k, v in cnt.items() if max(cnt.values()) == v and v > 1])

    return sorted(answer)
