# About
An example project for Apache Wicket showing off a possible bug.

In **Wicket 7.x.x** uploading the file upon changing the FileUploadField would 
automatically trigger the UploadProcessBar.

In **Wicket 8.x.x** uploading the file upon changing the FileUploadField 
does not trigger the UploadProcessBar automatically.
Submitting the form via the submit button does trigger the UploadProcessBar.

You can reproduce this behaviour by using the attached example projekt and 
changing the Wicket versions between 7.x.x and 8.x.x (see **build.gradle**).

## How to run
1. You can build the project with ```gradlew war``` and deploy it
to a local tomcat (I used [Tomcat 9](https://tomcat.apache.org/download-90.cgi))

2. Therefore copy the .war from */build/libs/* and paste 
   it in *<PATH_TO_YOUR_TOMCAT>/webapps/*

3. Start you tomcat by running *<PATH_TO_YOUR_TOMCAT>/bin/Tomcat9.exe*

4. Go to **http://localhost:<TOMCAT_PORT>/wicket-fileupload-1.0/**