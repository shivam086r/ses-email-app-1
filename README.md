### Commands ###

ssh -i SES-Java.pem ubuntu@IP

sudo yum install java-11-amazon-corretto

java -version

sudo yum install maven -y

mvn -v

git clone https://github.com/shivam086r/ses-email-app-1.git

cd ses-email-app-1

mvn clean install

java -jar target/ses-email-app-1.0-SNAPSHOT.jar
