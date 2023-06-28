even_sum = 0  # Variable to store the sum of even numbers
all_sum = 0  # Variable to store the sum of all numbers
error_flag = False  # Flag to track if an odd number is entered

while True:
    num = int(input("Enter a positive even number (or negative even number to exit): "))

    if num % 2 != 0:  # Check if the number is odd
        if num < 0:
            break  # Exit the loop if negative even number is entered
        else:
            error_flag = True
            break  # Exit the loop if odd number is entered
    else:
        if(num<0):
            break  # Exit the loop if negative even number is entered

    even_sum += num
    all_sum += num

if error_flag:
    print("Error: You entered an odd number.")
    print("Sum of even numbers so far:", even_sum)
else:
    print("Sum of all numbers entered:", all_sum)
