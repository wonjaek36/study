import psutil
import pprint

pp = pprint.PrettyPrinter(indent = 4)

pp.pprint ('psutil.cpu_times(True)')
pp.pprint (psutil.cpu_times(True))
print ()

pp.pprint ('psutil.cpu_percent(True)')
pp.pprint (psutil.cpu_percent(True))
print ()

pp.pprint ('psutil.cpu_percent(percpu=True)')
pp.pprint (psutil.cpu_percent(percpu=True))
print ()
