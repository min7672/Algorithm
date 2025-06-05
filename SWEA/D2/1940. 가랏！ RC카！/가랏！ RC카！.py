
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    line=int(input())
    
    current=0
    result=0
    for _ in range(line):
        
        
        cmd= input()
        if cmd[0]=='1':
            #가속
            current=current+int(cmd[2])    
        elif cmd[0]=='2':
            #감속
            current= current-int(cmd[2])
        if current<0 :
            current=0
        result=result+current
        
    print(f'#{test_case} {result}')