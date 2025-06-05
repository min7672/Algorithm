def make_90arr(_arr,_N):
    arr_90=[]
    for j in range(0,_N):
        tmp=[]
        for i in range(_N-1,-1, -1):
            tmp.append(_arr[i][j])
        arr_90.append(tmp)
    return arr_90
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N=int(input())
    arr=[list(map(int, input().split())) for _ in range(N)]
    
    arr90=make_90arr(arr,N)
    arr180=make_90arr(arr90,N)
    arr270=make_90arr(arr180,N)
    print(f'#{test_case}')
    for i in range(N):
        print(''.join(list(map(str,arr90[i]))),''.join(list(map(str,arr180[i]))),''.join(list(map(str,arr270[i]))))
        
        
    