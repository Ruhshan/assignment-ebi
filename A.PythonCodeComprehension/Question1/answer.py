from random import shuffle


def foo(length):
    list = range(1, length + 1)
    shuffle(list)
    return list


x = foo(10)

print x
