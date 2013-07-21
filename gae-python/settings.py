'''
Created on 2013/07/21

@author: Hito
'''
import os
BASE_DIR = os.path.dirname(os.path.abspath(__file__));

TEMPLATE_LOADERS = (
                    'django.template.loaders.filesystem.Loader',
                    'django.template.loaders.app_directories.Loader',
)

TEMPLATE_DIRS = (
                 os.path.join(os.path.dirname(__file__), 'templates'),
)
