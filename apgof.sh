#!/bin/bash
arguments="$@"
/usr/lib/jvm/java-7-openjdk-amd64/bin/java -cp '/home/eferrante/workspace/apgof2/bin/:/home/eferrante/workspace/apgof2/libs/*' apgof2.Apgof ${arguments}
