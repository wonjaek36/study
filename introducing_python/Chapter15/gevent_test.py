import gevent
from gevent import monkey; monkey.patch_all()

from gevent import socket

# Change socket to greenlet
# monkey.patch_socket()

hosts = [
    'www.crappytaxidermy.com',
    'www.walterpottertaxidermy.com',
    'www.antique-taxidermy.com',
    'www.naver.com'
]

jobs = [gevent.spawn(gevent.socket.gethostbyname, host) for host in hosts]
gevent.joinall(jobs, timeout=10)

for job in jobs:
    print (job.value)

