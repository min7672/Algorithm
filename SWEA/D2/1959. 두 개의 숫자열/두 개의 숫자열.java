
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N,M= map(int, input().split())
    arr_n=list(map(int, input().split()))
    arr_m=list(map(int, input().split()))

    if N>M:  #M이 무조건 큰 경우 
        tmp=arr_n
        arr_n=arr_m
        arr_m=tmp
        N=len(arr_n)
        M=len(arr_m)
    case_arr=[]
    for i in range(M-N+1):
        arr_t=arr_n.copy()
        for j in range( i):
            arr_t.insert(0,0)
        for k in range(M-len(arr_t)):
            arr_t.append(0)
        case_arr.append(arr_t)
        
    max_result=0
    for arr in case_arr:
        result=0
        for l in range(M):
            result=result+arr[l]*arr_m[l]
        if max_result<result:
            max_result=result
            
            
    print(f'#{test_case} {max_result}')