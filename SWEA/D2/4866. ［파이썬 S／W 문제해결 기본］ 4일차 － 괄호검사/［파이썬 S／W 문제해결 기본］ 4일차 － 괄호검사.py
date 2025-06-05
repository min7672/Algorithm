# 제출시간 : 2021. 9. 5. 오전 9:24:38
T= int(input())

for test_case in range(1, T+1):
    str1=input()
    stack_list= []
    top=-1
    for i in range(len(str1)):
        if( str1[i] == "{"  or str1[i]== "(" ):
            stack_list.append(str1[i])
            top= top+1
        if(len(stack_list)!=0):
            if((str1[i] == "}" and stack_list[top]=='{') 
             or  (str1[i] == ")" and stack_list[top]=='(')):
                del stack_list[top]
                top= top-1
            elif((str1[i] =="}" and stack_list[top]=="(") 
            or (str1[i]==")" and stack_list[top]=="{")):
                top=0
                break
                
        else:
            if (str1[i] == "}") or (str1[i]==")"):
                top=0
                break
    if( top == -1):
        print(f"#{test_case} 1")
    else:
        print(f"#{test_case} 0")
    
                   