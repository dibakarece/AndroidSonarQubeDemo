# AndroidSonarQubeDemo
SonarQube integration in Android for proper code review and code structuring.

Installing SonarQube:  
The installation is pretty straightforward, you have just to download an archive and extract it in a folder of your choice.    
1. Go to http://www.sonarqube.org/downloads/ and download the latest release.   
2. Unzip the archive   
3.Create a new SONAR_RUNNER_HOME environment variable and set variable value to D:\Yoru Folder\sonarqube-5.6.3   
4.Now add this SONAR_RUNNER_HOME to path variable >> %SONAR_RUNNER_HOME%\bin;   


Starting SonarQube  
1. Go to sonarqube-4.3/bin (or whatever version you downloaded)  
2. Open a corresponding folder according to your operating system (windows-x86-64 in my case). There you should see a file called StartSonar.bat (or sonar.sh for Linux)  
3. Just double click StartSonar.bat on windows (or Open up a terminal window and execute: sonar.sh start ). This command will start sonar listening on localhost:9000.  
4. Open a browser and enter localhost:9000. The sonar web page should open.  
Note that it may take some time until sonar loads, so if you get “page not found” in your browser, try to refresh the page later.  

![pic_2](https://cloud.githubusercontent.com/assets/10453203/20650565/b647c3e0-b4f7-11e6-8771-31e6145f8b4d.JPG)

![pic_1](https://cloud.githubusercontent.com/assets/10453203/20650564/b3643c76-b4f7-11e6-887b-9a362c23f9cb.JPG)

![1](https://cloud.githubusercontent.com/assets/10453203/20650624/d18e71e8-b4f8-11e6-99b0-e06451d2cb3d.png) ![2](https://cloud.githubusercontent.com/assets/10453203/20650636/15e15c0c-b4f9-11e6-858c-3e1a2d5bc43d.png)


#License
Copyright 2015 dibakar.ece@gmail.com Dibakar Mistry

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with the License. You may obtain a copy of the License in the LICENSE file, or at:

http://www.apache.org/licenses/LICENSE-2.0
