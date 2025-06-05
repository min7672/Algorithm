# 제출시간 : 2021. 9. 1. 오전 9:41:43

T= int(input())

for test_case in range(1, T+1):
    str1= input()
    
    cnt_str1= [ 0 for _ in range(len(str1))]
    
    str2= input()
    
    for j in range(len(str1)):
        for i in range(len(str2)):
            if(str1[j]==str2[i]):
                cnt_str1[j]=cnt_str1[j]+1
    max_num=0
    for k in range(1,len(cnt_str1)):
        if(cnt_str1[max_num]<cnt_str1[k]):
            max_num=k
    print(f"#{test_case} {cnt_str1[max_num]}")
