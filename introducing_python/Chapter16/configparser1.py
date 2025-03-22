import configparser

cfg = configparser.ConfigParser()
cfg.read('settings.cfg')

print (cfg)
print ()

print (cfg['french'])
print (cfg['french']['greeting'])

print ()
print (cfg['files']['bin'])
