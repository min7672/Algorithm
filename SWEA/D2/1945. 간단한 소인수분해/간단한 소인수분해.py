
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    num=int(input())
    div_arr=[2,3,5,7,11]
    result=[]
    for div in div_arr:
        cnt=0
        while True:
            if num%div !=0:
                result.append(str(cnt)) 
                break
            else:
                cnt=cnt+1
                num=num/div+num%div
    tmp=' '.join(result)
    print(f'#{test_case} {tmp}')