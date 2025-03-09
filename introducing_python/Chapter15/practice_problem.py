import time
import multiprocessing
import random
import os
import subprocess


NUM = 3


def timer():
    t = random.randint(1, 5)
    pid = os.getpid()
    time.sleep(t)
    date = subprocess.getoutput('date')
    
    print (f'pid: {pid} | date: {date}')



for num in range(NUM):
    p = multiprocessing.Process(target=timer)
    p.start()
