import csv

with open('villains', 'rt') as fin:
    cin = csv.DictReader(fin, fieldnames = ['first', 'last'])
    villains = [row for row in cin]

print(villains)
# Normal Dictionary, not OrderedDict
    
