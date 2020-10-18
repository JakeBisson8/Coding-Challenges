#Jake Bisson (jlb4@rogers.com / jbiss085@uottawa.ca)

#assumptions
#   Negative values are treated the same as its positive value
#   0 is considered a Spy number -> 0 = 0

#determines if a given integer value is a Spy Number
#Spy number is a number where the sum and product of its digits are equal
# e.g. 123 -> 1+2+3 = 1*2*3 so 123 is a Spy Number
#Runtime: O(N) where N is the number of digits in the value
def isSpy(value):
    #if the value is less than 0, we make it positive
    if value < 0: 
        value = value * -1
    
    #convert the number into a list of integers
    integer_list = []
    for x in str(value):
        integer_list.append(int(x))
    
    #find sum and product of all ints in the generated list
    sum_res = 0
    product_res = 1
    for x in integer_list:
        sum_res += x
        product_res *= x

    return sum_res == product_res

#returns a list of all of the spy numbers in a given range from 0-range
def findSpyNumbersIn(range):
    counter = 0
    results = []
    while counter <= range:
        if (isSpy(counter)):
            results.append(counter)
        counter+=1
    return results

def main():
    values = [123, 456, 789, 0, -123, 5]
    expected = [True, False, False, True, True, True]
    counter = 0
    for value in values:
        is_spy = isSpy(value)
        if is_spy == expected[counter]:
            print("[PASSED] Case ", counter, ": ", value)
        else:
            print("[FAILED] Case ", counter, ": ", value)
        counter+=1

    #gets list of spy numbers from 0-500
    spy_numbers = findSpyNumbersIn(10000)
    print("Spy numbers between 0-10000: ", spy_numbers)

#run the main function
main()