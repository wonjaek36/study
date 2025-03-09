import redis
import time


conn = redis.Redis()
print ('Dryer is starting')

while True:
    msg = conn.blpop('dishes')

    if not msg:
        time.sleep(3)

    val = msg[1].decode('utf-8')
    if val == 'quit':
        break

    print ('Dried', val)

print ('Dishes are dried')
