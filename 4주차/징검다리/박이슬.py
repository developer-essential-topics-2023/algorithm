def solution(distance, rocks, n):
    rocks.append(distance)
    rocks.sort()

    start, end = 0, 1000000000
    while start < end:
        mid = (start + end) // 2

        cnt, tmp = 0, 0
        for i in range(len(rocks)):
            if rocks[i] - tmp < mid:
                cnt += 1
            else:
                tmp = rocks[i]

        if cnt > n:
            end = mid
        else:
            start = mid + 1

    return start - 1
