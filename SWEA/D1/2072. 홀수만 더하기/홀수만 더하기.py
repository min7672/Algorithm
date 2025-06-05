T = int(input())

for test_case in range(1, T + 1):
    result=0
    num_list=map(int, input().split())
    for x in num_list:
        if x%2 ==1:
            result+= x
    print(f'#{test_case} {result}')
    