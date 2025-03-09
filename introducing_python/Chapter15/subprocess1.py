import subprocess

result = subprocess.getoutput('date')
print(f"date: {result}")

result = subprocess.getoutput('date -u')
print(f"date -u: {result}")

result = subprocess.getoutput('date -u | wc')
print(f"date -u | wc: {result}")

result = subprocess.check_output(['date', '-u'])
print(f"\ncheck_output / date -u: {result}")

result = subprocess.getstatusoutput('date')
print("\ngetstatusoutput: (exit code, result)")
print(f"getstatusoutput / date: {result}")

result = subprocess.call('date')
print("\ncall: (only return) exit_code")
print(f"call / date: {result}")

result = subprocess.call('date -u', shell=True)
print("\ncall / date: {result}")
print(f"call / date: {result}")

result = subprocess.call(['date', '-u'])
print("\ncall with array / call(['date', '-u'])")
print(f"call with array / date: {result}")
