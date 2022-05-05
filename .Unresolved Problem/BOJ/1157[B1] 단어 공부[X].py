text = input().upper()
unique_text = list(set(text))

alpha = []
for i in unique_text:
    temp = text.count(i)
    alpha.append(temp)
    
if alpha.count(max(alpha))>1:
    print('?')
    
else:
    print(unique_text[alpha.index(max(alpha))])