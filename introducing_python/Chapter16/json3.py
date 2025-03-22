import datetime
import json
from time import mktime

now = datetime.datetime.utcnow()
print (f'now: {now}')
try:
    json.dumps(now)
except TypeError as e:
    print (e)
print ()

now_str = str(now)
print (f'json.dumps(now_str): {json.dumps(now_str)}')
print ()

now_epoch = int(mktime(now.timetuple()))
print (f'json.dumps(now_epoch): {json.dumps(now_epoch)}')
print()
