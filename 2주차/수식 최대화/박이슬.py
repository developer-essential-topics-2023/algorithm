from itertools import permutations


def cal(a, priority):
    arr = a[:]
    for j in range(2):
        i = 0
        stack = []
        while i < len(arr):
            if arr[i] == priority[j]:
                stack.append(str(eval(stack.pop() + arr[i] + arr[i + 1])))
                i += 2
            else:
                stack.append(arr[i])
                i += 1
        arr = stack

    return abs(eval(''.join(stack)))


def solution(expression):
    arr = ['']
    for ex in expression:
        if ex.isdigit():
            arr[-1] += ex
        else:
            arr.extend([ex, ''])

    answer = 0
    for per in permutations('+-*', 3):
        answer = max(answer, cal(arr, per))

    return answer


print(solution("100-200*300-500+20"))
