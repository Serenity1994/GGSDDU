## 系统信息
* `uname -a`查看系统详细信息
* `df -h`显示硬盘容量
* `echo $JAVA_HOME`显示JAVA_HOME环境变量
  `echo`是输出字符串的指令

## 文件
* 查看文件详细信息:`ll` or `ls -l` or `ls -lh`
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
## install java
* `sudo add-apt-repository ppa:webupd8team/java`
* `sudo apt-get update`
* `sudo apt-get install oracle-java8-installer`
* `sudo apt-get install oracle-java7-set-default`
运行命令查看是否安装成功:`java -version`

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
## 搜狗输入法问题修复
* 搜狗输入法崩溃解决办法
  参考`https://www.findhao.net/res/786`

## install webstrom
* `tar -zxvf webstrom-xxx.tar.gz -C /home/serenity/`
* `cd /home/serernity/webstrom-xxx/bin`
* `sudo sh webstrom.sh`
* 破解：`http://idea.iteblog.com/key.php`

## ubuntu 解决非正常关闭apt-get的锁 
* `sudo rm -rf /var/cache/apt/archives/lock`
* `sudo rm -rf /var/lib/dpkg/lock`
* `sudo dpkg --configure -a`

## linux 输入法
* `sudo apt-get install fcitx fcitx-config-gtk fcitx-sunpinyin fcitx-googlepinyin fcitx-module-cloudpinyin`
* `sudo apt-get install fcitx-table-all`
* Fcitx输入中文时不显示候选词框的解决办法:`sudo apt remove fcitx-module-kimpanel`
>在非KDE桌面环境下，如果安装了fcitx-module-kimpanel，可能会导致Fcitx输入中文时不显示候选词框，移除该组件，然后重启Fcixt
* 

## 添加快捷方式和搜索
* 添加快捷键:创建文件`ideaUI.desktop`,内容如下
   ```
   [Desktop Entry]
   Name=IdeaIU
   Comment=IdeaIU
   Exec=/usr/local/idea/idea-IC-141.1010.3/bin/idea.sh //要启动的程序
   Icon=/usr/local/idea/idea-IC-141.1010.3/bin/idea.png //快捷键的图标
   Terminal=false //是否启动终端
   Type=Application
   Categories=Application;Development; //在哪里能搜索到,这个是按`win`搜索时所在的分类
   ```
* 将快捷方式放到搜索中:
   将快捷方式放在`/usr/share/applications/`文件夹下即可