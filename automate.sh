docker build -t $1 .

docker run -d -p $2:3000 $1
