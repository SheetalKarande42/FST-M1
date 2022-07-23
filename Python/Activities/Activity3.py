player1= input("Enter one option Rock/Paper/Scissor: ")
player2=input("Enter one option Rock/Paper/Scissor: ")
if player1=="Rock":
    if player2=="Scissor":
        print("Player1 wins")
    elif player2=="Paper":
        print("Player1 wins")
    else:
        print("tie")
elif player1=="Scissor":
    if player2=="Paper":
        print("Player1 wins")
    elif player2=="Rock":
        print("Player2 wins")
    else:
        print("tie")
elif player1=="Paper":
    if player2=="Rock":
        print("Player2 wins")
    elif player2=="Scissor":
        print("Player2 wins")
    else:
        print("tie")
else:
    print("Invalid input")