


T = int(input())

for test_case in range(1, T + 1):
    N, M = list(map(int, input().split()))
    lst = list(map(int, input().split()))
    for  i in range(M):
        lst.append(lst.pop(0));
    print(f'#{test_case} {lst[0]}')