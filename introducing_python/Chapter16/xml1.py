import xml.etree.ElementTree as et

tree = et.ElementTree(file='menu.xml')
root = tree.getroot()

print (f"{root}")

for child in root:
    print (f'tag: {child.tag}, attributes: {child.attrib}')

    for grandchild in child:
        print (f'\ttag: {grandchild.tag}, attributes: {grandchild.attrib}')


print (f'len(root): {len(root)}')
print (f'len(root[0]): {len(root[0])}')
