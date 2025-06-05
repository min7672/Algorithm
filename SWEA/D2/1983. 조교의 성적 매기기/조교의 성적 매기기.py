T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N,K= map(int,input().split())
    arr_score=[]
    score=['A+','A0','A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']
    for _ in range(N):
        mid, fin, assign=map(int,input().split())
        arr_score.append(mid*0.35+fin*0.45+assign*0.2)
    
    tmp=arr_score[K-1]
    

    arr_score.sort(reverse=True)
    
    rank=arr_score.index(tmp)
    print(f'#{test_case} {score[rank//(N//10)]}')
    
