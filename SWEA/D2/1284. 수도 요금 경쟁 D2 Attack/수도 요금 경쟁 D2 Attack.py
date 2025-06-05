
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    P,Q,R,S,W=map(int, input().split())
    a_cost=P*W
    b_cost=0
    if ( W<R) :
        b_cost=Q
    elif(W>R):
        b_cost=Q+(W-R)*S
    
    result=b_cost
    if b_cost>a_cost:
        result=a_cost
    print(f'#{test_case} {result}')
        