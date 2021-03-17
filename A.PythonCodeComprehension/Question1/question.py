from random import randint


def foo(length):
    list = []
    is_done = False
    while (is_done == False):
        r = randint(1, length)
        is_found = False
        for n in list:
            if (n == r):
                is_found = True
                break
        if (is_found == False):
            list.append(r)
        if (len(list) == length):
            is_done = True
    return list


x = foo(15)

print sorted(x)
