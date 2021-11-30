AWS EC2
1)Lunch AWS linux AMI machine, make sure security group has TCP rule with TCP port 22
2) Generate PEM file
3) Generate ppk file using pem file by using puttygen
4) Use putty and connect to VM
5) After openning VM machine CLI:
	1) Install Java 8, with bel0ow command:
	   #sudo yum install java-1.8.0-openjdk
	2) Verify JDK Installed:
	#java -version
	

Spring Boot Setup:

Create two jar file of your application with different artifact names so that we can upload it like two different files on S3 Bucketand deploy it on EC2 Machines
	

AWS S3:
1) create S3 Bucket to upload your jars, while creating allow public access
2) while updloading grant Public read access to files


Now Back to locally connected EC2 machine:
1) Download Jar with below command
#wget <S3URL>
2) Confirm item with ls command
3) run the Application with below command
	java -jar <jar_file>

Now back to your EC2 Machine deatils on AWS account

Click open address  link near Public IPv4 DNS and make it like below, http not https, 
also add the port and api url that you have set in spring boot to get the response

http://ec2-3-95-30-10.compute-1.amazonaws.com:8080/demo	

AWS Load Balancer: Applciation Load Balancer(Port will be http port 80)

Step 1 : Create Target Group and register your EC2 instances to this target group with port 8080(which our Spring Boot application are running on port 8080 inside EC2 instances

Step 2: Load Balancer -> Application Load Balancer
		Add the proper AZ with default subnets, also choose the security group which you have used for your EC2 machines(Basically which has TCP port 22 and All Traffic Enabled)

Step 3: Now Goto Lisioners -> Click on View/Edit Rules 	-> Add a new Rule 
Rule : 
IF
Path is/demo
THEN
Forward to
SBALB: 1 (100%)
Group-level stickiness: Off
 Step 4: Time for testing Load Balancer URL 
 Goto you ALB, discription Tab -> Copy your DNS Name URL -> Paste it in new Tab with your application specific URL, for example:
http://sbalb-771456915.us-east-1.elb.amazonaws.com/demo 

verify Result: Each time as an output you should get different IP address, becz I have returned the IP Address of Machine as an reponse from the GET API "/demo"
