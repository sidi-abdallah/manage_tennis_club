SIDI ABDALLAH Mohamed El Mokhtar 
AGHZERE Youssef


#####Inroduction

All the features acquired for the website were done :
* The passwords are registered in thier hash format. the class Hashing at
  the package fr.ensicaen.sidiabdallah.tennis.appli ensures all the hashing operations.
* The registeration and unregistration are possible
* ....

#####The feature create account

We have added a function which hasn't been acquired, it's the possibilty
to create an account on the website by clicking on the button create account. 
The user will be able to insert his data (name, email ...).
If the email already exist in the database then 
the a message ("Vous avez déja un compte ") will be displayed, 
otherwise the user will be added to the table Asherent.

To generate an adherent number unique for each user, we use the email
of the user. In fact, we hash the email and extract a number of 
5 digits.

#####To test our website
To test our website you can create your own adherents by create accounts, 
or you can use the users above who are already 
at the database : 
 adherentNumber        Email           Password
94789             mokhtar@gmail.com     123456
58734             rick@gmail.com       9876543210
72495             aghzere@gmail.com    0123456789 


