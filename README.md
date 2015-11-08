# Movie-Exporter
Movie aggregator with the use of reflections

[ Features]

→ Reflection based plugin architecture


[ Usage ]

→ To execute the program ,
First compile it using  
javac  MovieExporter.java
Then run it using
    java MovieExporter

→ The program will then list all the plugins available for receiving input and all the plugins available for exporting output.

→ Select the input method required and enter the class name of plugin as listed
→ Then after entering the input required, choose the output plugin and enter the name of the class of respective plugin

[ Implementation Details ]


Reflection and plugins

→ The details about a plugin and what it does is stored in a txt file.
→ Separate txt files are used to store details about input plugins and output plugins
→ When the program is executed, the details are taken from txt file and displayed to the user
→ This enables the user to understand what a plugin does without hardcoding it in any part of code
→ When a new plugin is to be added, it should just extend the base abstract class (DataWriter for input & DataInput for output) and add the details about what the plugin does in the respective txt file.
→ This way plugins can be used to easily extend the program functionality.

How reflection is actually used

→ The program actually accepts the class name as user input for plugin class and then instantiates an object for it using reflection.
→ It then uses the object to call the abstract class function,which is guaranteed to be implemented in all plugins which extends the base abstract class.[ input() for plugins that deal with input,outFile(HashMap<String,String> movieDetails) for plugins that deal with output ]
→ The details about which class name to enter for which plugin and what the plugin actually does are already displayed to the user at the start of program execution.


[ Future Work ]

→ Extending the program to make it work more intuitively using command line arguments.
→ Abstracting the classnames away from the user.
→ Removing the usage of txt files to store plugin information. 
→ Adding more user control throughout the program execution.
→ Adding more user level functionality

