# CompetenceMatrix

My program aims to aid an existing system, by providing an interface to the user to be able to manipulate a specific set of data. The system which I am referring to is called the Competence Matrix. The competence Matrix is a record that is kept by various companies to keep track of their existing course and details about those courses. I will make the program based on one company's Competence Matrix. 

Originally the Competence Matrix of said Company was managed through the use of an excel spreadsheet. However, over time, this spread sheet has grown to be quite lengthy and difficult manage. My program will counter-act this by using a database which is split up into five databases. Each of the databases will use the Competence Reference Number as a foreign key. The files will be of the type CSV, which means that each set of data is represented on a new line and the information about the data set, within that one line, will be separated by tab. My program will be able to display each of the five tables, as requested by the user, while keeping track of where the user currently is (in the database).

In terms of manipulation, my program will provide all the users with the ability to edit and delete selected cells or data sets respectively, as well as the ability to add a completely new data set (ie a new competence course) with what the user enters in as the values. These values will be checked, when the user enters them in, if they are of the correct type (ie int or string). A message will be displayed appropriately.

My program will also provide the user to sort the data sets by pre-determined sort methods: by total cost of the Competence or by Competence Reference Number. The user will also be able to search for a phrase within the data sets. The user will also be able to apply said search criteria quickly and with ease through the use of a checkbox.

Finally, all of the functions offered by buttons on the Main Frame user interface will be available as menu items on the menu bar.
