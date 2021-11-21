#!/bin/bash
lib='-I/usr/lib/jvm/java-11-openjdk-amd64/include'
name="libCompiler.so"
#name="task.so"
source="token.cpp"
#source="task.cpp"

g++ -w -Ofast -D library -fPIC -shared\
 -Wall -o $name $source\
 $lib $lib/linux
                                                  
if [ $? -ne 0 ]
then
  exit $?
fi

for i in *.class
do
 rm $i
done

rm ejavac.jar

javac AST.java 
if [ $? -ne 0 ]
then
  exit $?
fi
javac Compiler.java 
if [ $? -ne 0 ]
then
  exit $?
fi
javac ClassObject.java 
if [ $? -ne 0 ]
then
  exit $?
fi
javac ASTExpr.java 
if [ $? -ne 0 ]
then
  exit $?
fi
javac MethodLink.java 
if [ $? -ne 0 ]
then
  exit $?
fi
javac FieldLink.java 
if [ $? -ne 0 ]
then
  exit $?
fi

jar cvfm ejavac.jar META-INF/MANIFEST.MF *.class $name net org
if [ $? -ne 0 ]
then
  exit $?
fi

for i in *.class
do
 rm $i
done
