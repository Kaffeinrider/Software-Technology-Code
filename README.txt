Οδηγός για τρέξιμο του project.

1. 
Κατέβασμα της MySQL και του Netbeans αν δεν υπάρχουν ήδη.

2. 
Μπαίνετε στο MySQL Command Line Client με το κωδικό που είχατε βάλει όταν κατεβάζατε την MySQL και κάνετε όλο το περιεχόμενο του MySQL.txt copy-paste.

3. 
Εκτελείτε τις παρακάτω τρεις εντολές μία κάθε φορά εντολή στο MySQL Command Line Client.  

CREATE USER 'accountant'@'localhost' IDENTIFIED BY 'money';

GRANT ALL PRIVILEGES ON myaccountant.* TO 'accountant'@'localhost';

FLUSH PRIVILEGES;

4. 
Ανοίγουμε το Netbeans και κάνουμε Open Project το MyAccountant.

5. 
Τσεκάρουμε αν στα Libraries του MyAccountant υπάρχει το mysql-connector-j-8.0.31. 

Αν δεν υπάρχει ήδη τότε κάνετε δεξί κλικ στο Libraries και πατάτε την επιλογή "ADD JAR/FOLDER" και επιλέγετε το mysql-connector-j-8.0.31 που υπάρχει ήδη.

6.
Τώρα αν έχουν πάει όλα καλά μπορούμε να τρέξουμε το project.

7.
Aναφέρουμε ποιες κλάσεις είναι έτοιμες.

Για τον user:
MyAccountant (Status: Finished)
Login (Status: Finished)

Για τον Ιδιώτη:
Idiotis (Status: Finished)
Epilogi_Logisti (Status: Finished)
Portofoli (Status: Finished)
Oxima (Status: Finished)
YpovoliDiloseonEkkatharistikwn (Status: Finished)
Provoli_Ofeilon (Status: Finished)

Για τον Λογιστή:
Logistis (Status: Finished)
EnimerosiEsodwnEksodwn (Status: Finished)
ProsthikiYpallilwn (Status: Finished)
RithmisiOfeilwn (Status: Finished)
Ipovoli_diloseon (Status: Finished)
DiaxeirisiAitimatwn (Status: Finished)
DiaxeirisiOximaton (Status: Finished)
EkdosiVevaiosisMiOfeilis (Status: Finished)
EpeksergasiaYpallilwn (Status: Finished)

Για την Επιχείρηση:
Epixeirisi (Status: Finished)
Epilogi_Logisti (Status: Finished)
Portofoli (Status: Finished)
Oxima (Status: Finished)
Provoli_stoixeion_Epixeirisis (Status: Finished)
Provoli_Ofeilon (Status: Finished)

8.
Μπορούμε να δούμε τους κωδικούς και τα ονόματα των χρηστών από τα Insert που κάνουμε στο MySQL.txt.

Λογιστές:
Username: kappaXD
Password: yooo

Username: SuperMan61
Password: drakos_fotia

Ιδιώτες:
Username: XXXgamerXXX
Password: yo21

Username: Giota103
Password: hihihi

Επιχειρήσεις:
Username: Sony
Password: sony1234

Username: Papageorgiou Lastixa
Password: 5235