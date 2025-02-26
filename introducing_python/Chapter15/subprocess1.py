import subprocess

result = subprocess.getoutput('date')
print(f"date: {result}")

result = subprocess.getoutput('date -u')
print(f"date -u: {result}")

result = subprocess.getoutput('date -u | wc')
print(f"date -u | wc: {result}")
