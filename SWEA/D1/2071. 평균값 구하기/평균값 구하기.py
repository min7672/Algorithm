T = int(input())

for test_case in range(1,T+1):
    result=0
    cnt=0
    num_list=map(int,input().split())
    for x in num_list:
        result+=x
        cnt+=1;
    if result/cnt-result//cnt>=0.5:
        print(f'#{test_case} {result//cnt+1}')
    else:
        print(f'#{test_case} {result//cnt}')