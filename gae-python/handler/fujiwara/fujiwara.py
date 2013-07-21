# -*- coding: utf-8 -*-
import os
import settings
import django.template.loader

from google.appengine.ext import webapp
from google.appengine.ext.webapp.util import run_wsgi_app
from google.appengine.ext.webapp import template
import cgi


class MainPage(webapp.RequestHandler):

    def get(self):
        layout = django.template.loader.get_template('base.html');
        template_values = {};
        template_values["layout"] = layout;
        path = os.path.join(settings.BASE_DIR, "templates/fujiwara/fujiwara.html")
        self.response.out.write(template.render(path, template_values));

    def post(self):
        inputMsg = self.request.get('inputMessage');
        converted = "";
        for c in inputMsg:
            converted = converted + c + u"゛";

        org = cgi.escape(inputMsg)
        msg = cgi.escape(converted)
        layout = django.template.loader.get_template('base.html');
        template_values = {};
        template_values["layout"] = layout;
        template_values["outputMessage"] = msg;
        template_values["inputMessage"] = org;
        
        path = os.path.join(settings.BASE_DIR, "templates/fujiwara/fujiwara.html")
        self.response.out.write(template.render(path, template_values));

application = webapp.WSGIApplication([('/fujiwara/?', MainPage)], debug=True)


def main():
    run_wsgi_app(application)

if __name__ == "__main__":
    main()
