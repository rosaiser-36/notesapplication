#########
# date 14 -07 -2024
# author Roshn
# to run the python application using docker
##############


docker build -t $1 .

docker run -d -p $2:3000 $1

echo ' Your docker is running at localhost:$2 and image name is $1'
