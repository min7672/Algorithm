
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    input()
    arr=list(map(int,input().split()))
    arr.sort()
    arr.reverse()
    cnt_m=0
    v_m=arr[0]
    cur_cnt=0
    cur_m=arr[0]
    for i in range(len(arr)):
        if cur_m==arr[i]:
            cur_cnt=cur_cnt+1
        else:
            if cur_cnt>cnt_m:
                cnt_m=cur_cnt
                v_m=cur_m
            cur_cnt=1
            cur_m=arr[i]
    print(f'#{test_case} {v_m}')
        