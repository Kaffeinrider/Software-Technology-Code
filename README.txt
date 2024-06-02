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
Έχουμε κάνει ένα μέρος των λειτουργειών που είχαμε σχεδιάσει. Επομένως θα αναφέρουμε ποιες κλάσεις είναι έτοιμες.

Για τον user:
MyAccountant (Status: Finished)
Login (Status: Finished)

Για τον Ιδιώτη:
Idiotis (Status: Finished)
Epilogi_Logisti (Status: Finished)
Portofoli (Status: Finished)
Oxima (Status: semi-Finished)
YpovoliDiloseonEkkatharistikwn (Status: semi-Finished)

Για τον Λογιστή:
Logistis (Status: Finished)
EnimerosiEsodwnEksodwn (Status: Finished)
ProsthikiYpallilwn (Status: Finished)
RithmisiOfeilwn (Status: Finished)

Για την Επιχείρηση:
Epixeirisi (Status: Finished)
Epilogi_Logisti (Status: Finished)
Portofoli (Status: Finished)
Oxima (Status: semi-Finished)
Provoli_stoixeion_Epixeirisis (Status: Finished)

Unfinished classes:
DiaxeirisiAitimatwn
DiaxeirisiOximaton
EkdosiVevaiosisMiOfeilis
EpeksergasiaYpallilwn
Ipovoli_diloseon
Provoli_Ofeilon