## 系统信息
* `uname -a`查看系统详细信息

## 文件
* `rm /home/test.txt`删除文件
* `rmdir /home/test`删除文件夹
   当文件夹非空是时会报错
* `rm -rf /home/test`循环删除当前文件夹及其里面文件  <br>
   r就是向下递归<br>
   f就是直接强行删除，不做任何提示
* `cp /home/test.txt /home`copy
* `mkdir test` new
* `tar -zxvf jdk-8u60-linux-x64.tar.gz`

## 设置全局变量
`$ sudo ln -s /home/ubuntu/node-v4.5.0-linux-x86/bin/node /usr/local/bin/node`
将`/home/ubuntu/node-v4.5.0-linux-x86/bin/`路径下的node程序设置成全局变量，这样就可以直接在任何地方直接输入`node`
>`ln` 链接命令   
`-s` 软链接<br>
`/usr/local/bin`大部分发行版把这个目录归为PATH即你在这个目录下放了什么可执行的程序，在系统任何地方都可以直接执行，不需要指定路径

## 查找命令所在的位置
`which java`查找java所在的位置，这样一路找下来就能找到java安装的位置了

## 设置java环境变量
java安装的路径`/usr/lib/jvm/java-8-openjdk-amd64/bin`
* 方法一：直接修改/etc/profile文件

## 查看apt-get安装软件的信息
* `dpkg -L packagename` 查询系统中已安装的软件的位置
* `dpkg -s packagename` 查看安装软件的详细信息  
   <br>`dpkg`是debain package的缩写，
   <br>dpkg命令是Debian Linux系统用来安装、创建和管理软件包的实用工具。
## 卸载软件
* 删除软件及配置文件
  `sudo apt-get --purge remove packagename`
* 删除没有用的依赖包
  `sudo apt--get autoremove packagename`
* 此时dpkg的列表中有“rc”状态的软件包，可以执行如下命令做最后清理：
  `dpkg -l |grep ^rc|awk '{print $2}' |sudo xargs dpkg -P`
                                
