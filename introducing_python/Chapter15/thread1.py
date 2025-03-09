import threading


def do_this(what):
    whoami(what)


def whoami(what):
    print ("Thread %s says: %s" % (threading.current_thread(), what))


if __name__ == '__main__':
    whoami("I'm the main program")

    for n in range(4):
        p = threading.Thread(target=do_this, args=("I'm function %s" % n,))
        p.start()


"""
$ python thread1.py
Thread <_MainThread(MainThread, started 127433307360128)> says: I'm the main program
Thread <Thread(Thread-1, started 127433277703744)> says: I'm function 0
Thread <Thread(Thread-2, started 127433267217984)> says: I'm function 1
Thread <Thread(Thread-3, started 127433277703744)> says: I'm function 2
Thread <Thread(Thread-4, started 127433267217984)> says: I'm function 3
"""
