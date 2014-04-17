all:
	/usr/lib/jvm/java-7-openjdk-amd64/bin/javac -cp libs/gems-2011.09-bin.jar -sourcepath src src/apgof2/Apgof.java -d bin

clean:
	rm -f bin/apgof/*
