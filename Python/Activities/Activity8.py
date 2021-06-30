numList = list(input("Enter the sequence of comma seperated values : ").split(","))
print("Given list is ", numList)

# Check if first and last element are equal
if (numList[0] == numList[-1]):
    print("True")
else:
    print("False")

