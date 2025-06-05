# 제출시간 : 2021. 8. 24. 오후 4:11:47

T = int(input())
card_deck=[i for i in range(1,13)]

n=len(card_deck)
for test_case in range(1, T+1):
    N, K = map(int, input().split())
    
    n_subset= []
    
    for i in range(1<<n):
        tmp=[]
        
        for j in range(n):
            if ( i &( 1<<j)):
                tmp.append(card_deck[j])
        if(len(tmp)==N and sum(tmp)==K):
            n_subset.append(tmp)
    print(f"#{test_case} {len(n_subset)}")
    
    