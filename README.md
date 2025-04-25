### Commands ###

ssh -i SES-Java.pem ec-user@IP

sudo yum install java-17-amazon-corretto -y

java -version

sudo yum install maven -y

mvn -v

git clone https://github.com/shivam086r/ses-email-app-1.git

cd ses-email-app-1

mvn clean install

java -jar target/ses-email-app-1.0-SNAPSHOT.jar
