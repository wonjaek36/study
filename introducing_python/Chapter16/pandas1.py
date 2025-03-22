import pandas

data = pandas.read_csv('villains.csv', header=None, names=['first', 'last'])

print (data)
