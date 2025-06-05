T=int(input())
for test_case in range(1,T+1):
    text=input()
    result=0
    for i in range(1,11):
        if len(text)<i*2:
            result=0
        else:
            if text[:i+1] == text[i:2*i+1]:
                result=i
                break
            else:
                result=0
    print(f'#{test_case} {result}')
                
              
            