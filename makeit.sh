mkdir -p target/src_no_pkg
cd target/src_no_pkg
for f in `find ../../src/main/scala/aicontest/ -name "*.scala"`; do grep -v "package" $f > `echo $f | cut -d'/' -f7`; done
scalac -unchecked -deprecation *.scala
rm -rf ../zip
mkdir ../zip
jar cvMf ../zip/bot.zip *.scala

