### Commands ###

ssh -i ssh-key-location ec2-user@IP

sudo yum install java-17-amazon-corretto

java -version

sudo yum install maven -y

mvn -v

sudo yum install git -y

git clone --branch for-linux-machine --single-branch https://github.com/shivam086r/ses-email-app-1.git

cd ses-email-app-1

mvn clean install

java -jar target/ses-email-app-1.0-SNAPSHOT.jar
