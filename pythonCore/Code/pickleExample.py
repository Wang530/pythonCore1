# -*- coding:utf-8 -*-
"""
Author：wang
Date:2021:05:25
"""
import pickle
f = open("dump.txt",'ab')
d = dict(name='Bob',age = 18)
pickle.dump(d,f)

f.close()

f = open("dump.txt",'rb')
d = pickle.load(f)
f.close()
print(d)