# e-commerce
V-Market

It is a simple store. you can search products you want and buy them. It is linked to Stripe for making possible to check cridit cart and some payments.

To start with venv or sth like this:

    #install venv and activate it
    $ py -m venv venv
    $ venv/Scripts/activate
    
    #install all requirements
    (venv)
    $ pip install -r req.txt
    
Run Django:
    
    #Open django project derectory
    $ cd vmarketdjango/
    
    #Run it
    (venv)
    $ py manage.py runserver
    Performing system checks...

    System check identified no issues (0 silenced).
    April 28, 2023 - 08:59:49
    Django version 4.0.2, using settings 'vmarketdjango.settings'
    Starting development server at http://127.0.0.1:8000/
    Quit the server with CTRL-BREAK.
    
Run Vue:

    #You should install Vue.js with Node.js on your PC
    #Then, you can start
    $ cd vmarketvue/
    
    #Run it
    $ npm run serve

    > vmarketvue@0.1.0 serve
    > vue-cli-service serve

     INFO  Starting development server...


     DONE  Compiled successfully in 3823ms                                                                                                          10:25:37 AM


      App running at:
      - Local:   http://localhost:8080/ 
      - Network: http://172.16.7.228:8080/

      Note that the development build is not optimized.
      To create a production build, run npm run build.



     WAIT  Compiling...                                                                                                                             10:25:37 AM

    Compiling...
      App running at:
      - Local:   http://localhost:8080/
      - Network: http://172.16.7.228:8080/
