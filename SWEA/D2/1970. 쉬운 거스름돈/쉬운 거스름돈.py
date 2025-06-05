
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    reCash=int(input())
    cash_case=[50000,10000,5000,1000,500,100,50,10]	
    cash_num=[]
    for money in cash_case:
        cash_num.append(reCash//money)
        reCash=reCash%money
    result=' '.join(map(str,cash_num))
    print(f'#{test_case}\n{result}')
    
    