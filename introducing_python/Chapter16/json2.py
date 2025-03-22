import json

with open('menu.json', 'r', encoding='utf-8') as file:
    menu = json.load(file)

menu_json = json.dumps(menu)
print (f'menu_json: {menu_json}')
print (f'type(menu_json): {type(menu_json)}')
print ()

menu2= json.loads(menu_json)
print (f'menu2: {menu2}')
print (f'type(menu2): {type(menu2)}')
