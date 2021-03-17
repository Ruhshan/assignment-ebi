from random import shuffle


def foo(length):
    list_for_random = range(length + 1)
    shuffle(list_for_random)
    return list_for_random


x = foo(10)

print x
