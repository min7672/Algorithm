T=int(input())

for test_case in range(1,1+T):
    cnt=int(input())
    num_list=list(map(int,input().split()))
    min=num_list[0]
    max=num_list[0]
    for x in num_list:
        if min>x:
            min=x
        if max < x:
            max=x
    print(f'#{test_case} {max-min}')