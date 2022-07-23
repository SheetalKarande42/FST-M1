#List Sum Calculator

nums=list(input("Enter comma separated numbers to calculate sum : ").split(", "))

sum=0
for num in nums:
    sum=sum+int(num)

print(sum)
