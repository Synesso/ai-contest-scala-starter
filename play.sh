r=$RANDOM
let r%=100
let r+=1
java -jar starter_pack/tools/PlayGame.jar starter_pack/maps/map$r.txt 3000 200 log.txt "java -cp project/boot/scala-2.8.0/lib/scala-library.jar:target/src_no_pkg MyBot" "java -jar starter_pack/example_bots/RandomBot.jar" | java -jar starter_pack/tools/ShowGame.jar 

