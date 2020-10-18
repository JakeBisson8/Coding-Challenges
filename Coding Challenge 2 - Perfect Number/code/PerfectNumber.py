
#Runtime: O(N) Where N is the size of value
def isPerfectNumber(value):
    #if value is 0 we return false
    if value==0:
        return False
    #if value is negative, we treat as if it was positive
    if value < 0:
        value = value*-1

    #limit defines the possible range a common divisor for value can be found
    limit = int(value / 2)
    sum_res = 0
    i=1
    #looping from 0-limit, if the value is divisible by current value add the current value to the sum since it is considered a common divisor
    while i<=limit: 
        if value%i == 0:
            sum_res+=i
        i+=1
    return sum_res == value

#returns a list of all perfect numbers within the range of 0-range
def findPerfectNumbersIn(range):
    counter = 0
    results = []
    while counter <= range:
        if isPerfectNumber(counter):
            results.append(counter)
        counter+=1
    return results


#main function 
def main():
    values=[6, 0, 28, -496, 7, 8, 1]
    expected=[True, False, True, True, False, False, False]
    counter = 0
    for value in values:
        if isPerfectNumber(value) == expected[counter]:
            print("[PASSED] Case ", counter, ": ", value)
        else:
            print("[FAILED] Case ", counter, ": ", value)
        counter+=1
    
    perfect_numbers = findPerfectNumbersIn(8130)
    print("List of perfect numbers in range 0-8200", perfect_numbers)

#run main function
main()