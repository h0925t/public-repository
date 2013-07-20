# -*- coding: utf-8 -*-

from google.appengine.ext import webapp
from google.appengine.ext.webapp.util import run_wsgi_app
import os
from google.appengine.ext.webapp import template
import cgi


class MainPage(webapp.RequestHandler):
    
    def get(self):       
        template_values = {};
        path = os.path.join(os.path.dirname(__file__), "../templates/fujiwara.html")
        self.response.out.write(template.render(path, template_values));
        
    def post(self):
        inputMsg = self.request.get('inputMessage');
        converted = "";
        for c in inputMsg:
            converted = converted + c + u"゛";
        
        org = cgi.escape(inputMsg)
        msg = cgi.escape(converted)
        template_values = {"outputMessage":msg,"inputMessage":org};
        path = os.path.join(os.path.dirname(__file__), "../templates/fujiwara.html")
        self.response.out.write(template.render(path, template_values));

application = webapp.WSGIApplication([('/fujiwara', MainPage)], debug=True)


def main():
    run_wsgi_app(application)

if __name__ == "__main__":
    main()
