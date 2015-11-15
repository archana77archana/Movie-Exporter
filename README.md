# MOVIE AGGREGATOR
***


A console based application that accepts movie details like Name, Run Time, Language, Lead Actor and Genre and exports these details into  any format that the user asks for.

### [ Features]

* Reflection based plugin architecture

### [ Usage ]

* To execute the program ,
First compile it using  
**javac  MovieExporter.java**
Then run it using
    **java MovieExporter**

* The program will then list all the plugins available for receiving input and all the plugins available for exporting output.

* Select the input method required and enter the class name of plugin as listed

* Then after entering the input required, choose the output plugin and enter the name of the class of respective plugin

### [ Implementation Details ]

**Reflection and plugins**

* The details about a plugin and what it does is stored in a txt file.
* Separate txt files are used to store details about input plugins and output plugins
* When the program is executed, the details are taken from txt file and displayed to the user
* This enables the user to understand what a plugin does without hardcoding it in any part of code
* When a new plugin is to be added, it should just extend the base abstract class (DataWriter for output & DataInput for input) and add the details about what the plugin does in the respective txt file.
* This way plugins can be used to easily extend the program functionality.

**How reflection is actually used**

* The program actually accepts the class name as user input for plugin class and then instantiates an object for it using reflection.

* It then uses the object to call the abstract class function, which is guaranteed to be implemented in all plugins which extends the base abstract class. [ input() for plugins that deal with input, outFile(HashMap<String,String> movieDetails) for plugins that deal with output ]

* The details about which class name to enter for which plugin and what the plugin actually does are already displayed to the user at the start of program execution.

### [Default Input.java]

* The DefaultInput class is used to get user input from the stdinput and it comprises of 2 functions.

* The private function getInput takes an HashMap as an argument. It prompts the user to enter various movie details and then adds them as key-value pair into the HashMap.It then returns this populated HashMap

* The public function input() exposes the getInput() function to the Main class.This function is  required as this class is an extension of DataInput class,and it is this function that is going to get called for this plugin to work.

**Benefit of having input plugins**

* Instead of just relying on getting input from stdin console, in the future, you can have plugins to read the input from different file formats etc.
 
* For example , in future this program can be extended to work as an file format conversion utility with features that enable it to convert between file formats such as txt,pdf,doc ect.This can only be possible by using input plugins.

* By allowing input to be also defined by plugins we allow the program to be modular and extendable just as previously mentioned beyond the scope of its original author.

### [MethodInp.java]

* The MethodInp class is used to print details of the plugins included. It comprises of two functions.

* The private function readDetails() outputs the contents of the file, specified by its File argument, onto stdout.

* The function methodIn() accepts fileName from the user, checks if the file exists and if it does,it calls readDetails() on the file object to print its contents on stdout.

### [Pdfouter.java]

* The Pdfouter class is used to get the input exported into PDF format.

* The private function createPdf() which takes the filename as the argument creates the pdf.

* The private addDetails() function which takes two arguments, one of the hashmap and another one the document object of the created pdf. The function opens the document and writes the information read from the input plugin specified by user.

* The function outfile() takes the hashmap as an argument, and asks the user to input the name of the pdf file. If the user doesn’t give a file name, we do have a default file name. It calls the createPdf() and then the addDetails() function.

### [Txtouter.java]

* TheTxtouter class is used to the get the input export exported into TXT format

* The private function createTxt() takes the file name as argument and creates the text file.

* The private addDetails() function which takes two arguments, one of the hashmap and another one the file object of the created txt file. The function opens the file and writes the information read from the input plugin specified by user.

* The function outfile() takes the hashmap as an argument, and asks the user to input the name of the txt file. If the user doesn’t give a file name, we do have a default file name. It calls the createTxt() and then the addDetails() function.

### [ Future Work ]

* Extending the program to make it work more intuitively using command line arguments.
* Abstracting the classnames away from the user.
* Removing the usage of txt files to store plugin information. 
* Adding more user control throughout the program execution.
* Adding more user level functionality
