import sys

if __name__ == "__main__":
    N = int(sys.stdin.readline().rstrip())
    toppings = sys.stdin.readline().rstrip().split()
    cheese_set = set()
    for topping in toppings:
        if topping.endswith('Cheese'):
            cheese_set.add(topping)
            if len(cheese_set) >= 4:
                sys.stdout.write('yummy\n')
                break
    else:
        sys.stdout.write('sad\n')