name=input("Enter you name - ")
age=input("Enter your age - ")
outage=int(age)+100
text="The year that " +name+ " will turn 100 years old is - {}"
print(text.format(outage))