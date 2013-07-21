# -*- coding: utf-8 -*-
import os
import settings
import django.template.loader


from google.appengine.ext import webapp
from google.appengine.ext.webapp.util import run_wsgi_app
from google.appengine.api import users
from google.appengine.ext.webapp import template
from google.appengine.ext import db

class MainPage(webapp.RequestHandler):

    def get(self):
        user = users.get_current_user();

        if user:
            name = user.nickname();
            user_login = UserLogin();
            user_login.user = user;
            user_login.put();
        else:
            name = "Guest";


        layout = django.template.loader.get_template('base.html');        
        template_values = {};
        template_values["layout"] = layout;
        template_values["name"] = name;
        
        path = os.path.join(settings.BASE_DIR, "templates/index/index.html");
        self.response.out.write(template.render(path, template_values));

class UserLogin(db.Model):
    user = db.UserProperty();
    date = db.DateTimeProperty(auto_now_add=True);

application = webapp.WSGIApplication([('/', MainPage)], debug=True);

def main():
    run_wsgi_app(application);

if __name__ == "__main__":
    main();
