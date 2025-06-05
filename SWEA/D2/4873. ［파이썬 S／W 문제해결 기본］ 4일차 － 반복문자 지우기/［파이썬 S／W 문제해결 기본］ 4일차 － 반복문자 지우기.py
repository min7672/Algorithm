# 제출시간 : 2021. 9. 5. 오전 9:40:54
T=int(input())

for test_case in range(1,T+1):
    str1=input()
    stack_list=[str1[0]]
    top=0
    
    for i in range(1,len(str1)):
        if(len(stack_list)==0):
            stack_list.append(str1[i])
            top=top+1
        else:
            if( stack_list[top] != str1[i]):
                stack_list.append(str1[i])
                top=top+1
            else:
                del stack_list[top]
                top=top-1
    print(f"#{test_case} {top+1}")