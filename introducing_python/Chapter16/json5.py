import datetime
import json
from time import mktime

now = datetime.datetime.utcnow()
class DTEncoder(json.JSONEncoder):
    def default(self, obj):
        # isinstance() check the type of obj
        # Everything is object in python
        if isinstance(obj, datetime.datetime):
            return int(mktime(obj.timetuple()))
        return json.JSONEncoder.default(self, obj)


print (f'json.dumps(now, cls=DTEncoder): {json.dumps(now, cls=DTEncoder)}')
print ()

now = datetime.datetime.utcnow()
print (f'json.dumps(now, default=str): {json.dumps(now, default=str)}')
