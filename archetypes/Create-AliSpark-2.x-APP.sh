usage="Usage: sh Create-AliSpark-2.x-APP.sh <app_name> <target_path>"
sh Create-AliSpark-2.x-APP.sh spark-2.x-demo /tmp/
cd /tmp/spark-2.x-demo
mvn clean package

# 冒烟测试 
# 1 利用编译出来的shaded jar包
# 2 按照文档所示下载MaxCompute Spark客户端
# 3 参考文档”置环境变量”指引，填写MaxCompute项目相关配置项

# 执行spark-submit命令 如下
$SPARK_HOME/bin/spark-submit \
        --master yarn-cluster \
        --class SparkPi \
      /tmp/spark-2.x-demo/target/AliSpark-2.x-quickstart-1.0-SNAPSHOT-shaded.jar

