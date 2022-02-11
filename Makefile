all: run

ZygoteInit.class: com/wave/ZygoteInit.java
	javac com/wave/ZygoteInit.java

app_process: app_process.c
	gcc -D__int64="long long" -I/usr/lib/jvm/java-8-openjdk-amd64/include  -I/usr/lib/jvm/java-8-openjdk-amd64/include/linux -o app_process app_process.c  -L/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/amd64/server -ljvm

run: ZygoteInit.class app_process
	./app_process

clean:
	rm -f com/wave/*.class app_process