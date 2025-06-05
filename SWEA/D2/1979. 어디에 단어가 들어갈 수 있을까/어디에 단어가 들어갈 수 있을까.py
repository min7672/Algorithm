T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N,K= map(int,input().split())
    arr_score=[]
    arr = [list(map(int, input().split())) for _ in range(N)]


    result=[]
    for i in range(N):
        cnt=0
        for j in range(N):
            if arr[i][j]==1:
                cnt=cnt+1
                if j== N-1:
                    result.append(cnt)
                    cnt=0
            elif (arr[i][j] ==0 and cnt!=0):
                result.append(cnt)
                cnt=0
    for j in range(N):
        cnt=0
        for i in range(N):
            if arr[i][j]==1:
                cnt=cnt+1
                if i== N-1:
                    result.append(cnt)
                    cnt=0
            elif (arr[i][j] ==0 and cnt!=0):
                result.append(cnt)
                cnt=0                
  
            
    print(f'#{test_case} {result.count(K)}')
    
