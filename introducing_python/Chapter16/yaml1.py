import yaml

with open('mcintyre.yaml', 'rt') as fin:
    text = fin.read()
    data = yaml.load(text, Loader=yaml.SafeLoader)

data['details']

print (f'len(data["poems"]): {len(data["poems"])}')

print (f'data["poems"][1]["title"]): {data["poems"][1]["title"]}')
