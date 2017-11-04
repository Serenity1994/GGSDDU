1. 安装输入法
2. 安装java8并配置环境变量
3. 安装git
4. 安装svn
5. 安装webstrom
6. 安装idea
7. 安装tomcat
8. 安装mysql
9. 安装oracle
10. 安装weblogic

## 安装oracle
参考`http://www.cnblogs.com/gaojun/archive/2012/11/22/2783257.html`
1. 创建oracle用户:
```
   `sudo /usr/sbin/groupadd oinstall`
   `sudo /usr/sbin/groupadd dba`
   `sudo /usr/sbin/useradd -g oinstall -G dba oracle`(主组oinstall,其他组:dba)
   `sudo passwd oracle` 输入新密码`root`
```   
2. 修改内核参数
>`sudo gedit /etc/sysctl.conf`添加如下参数:
```
fs.aio-max-nr = 1048576
fs.file-max = 6815744
kernel.shmall = 2097152
kernel.shmmax = 536870912
kernel.shmmni = 4096
kernel.sem = 250 32000 100 128
net.ipv4.ip_local_port_range = 9000 65500
net.core.rmem_default = 262144
net.core.rmem_max = 4194304
net.core.wmem_default = 262144
net.core.wmem_max = 1048586
```
3. 重新加载配置:`/sbin/sysctl -p`
4. 修改用户限制
>`sudo gedit /etc/security/limits.conf`添加如下参数:
```
oracle           soft    nproc   2047
oracle           hard    nproc   16384
oracle           soft    nofile  1024
oracle           hard    nofile  65536
```
5. 修改用户验证选项
>`sudo gedt /etc/pam.d/login`添加如下参数
```
session    required     pam_limits.so
```
6. 修改用户配置文件
>`sudo gedit /etc/profile`添加如下参数:
```
if [ $USER = "oracle" ]; then
        if [ $SHELL = "/bin/ksh" ]; then
              ulimit -p 16384
              ulimit -n 65536
        else
              ulimit -u 16384 -n 65536
        fi
fi
```
7. 安装目录配置
>`sudo mkdir -p /u01/oraInventory`
`chown -R oracle:oinstall /u01/`
`chmod -R 775 /u01/`
8. 修改用户bash shell
>`sudo gedit .bash_profile`
9. 安装oracle界面显示乱码:
>使用英文界面安装:
```
`su - oracle`
`export LANG=en_US.UTF-8`
`cd /home/serenity/oracle/database/`解压后的文件夹
`./runInstaller`
```

## 8.安装mysql
1. 首先要安装mysql的依赖库:`sudo apt-get install libaio-dev`
2. 解压`mysql-5.6.38-linux-glibc2.12-x86_64.tar.gz`到`/usr/local`下,并重命名文件夹名为mysql
3. 添加mysql组和mysql用户: <br>
`sudo groupadd mysql`<br>
`sudo useradd -r -g mysql mysql`
4. `cd /usr/local/mysql-5.6.38-linux-glibc2.12-x86_64`
5. 改变当前目录的拥有者为mysql用户:`sudo chown -R mysql:mysql ./`
6. 安装数据库:`./script/mysql_install_db --user=mysql --datadir=/usr/local/mysql/data/mysql`
7. 修改当前目录拥有者为root用户:`sudo chown -R root:root ./`
8. 修改当前data目录拥有者为mysql用户:`sudo chown -R mysql:mysql data`
9. 添加开机启动mysql服务,把启动脚本放到开机初始化目录:`sudo cp support-files/mysql.server /etc/init.d/mysql`
10. 修改启动脚本:<br> 
    `sudo vim /etc/init.d/mysql`
    修改项:
    ```
    basedir=/usr/local/mysql
    datadir=/usr/local/mysql/data/mysql
    ```
11. `sudo chmod 755 /etc/init.d/mysql`
12. `sudo cp suport-files/my-default.cnf /etc/my.cnf`
13. 启动mysql服务:`sudo service mysql start`
14. 查看mysql状态:`service mysql status`
15. 关闭mysql:`service mysql stop`
16. 添加mysql环境变量,这样就可以在任何地方使用mysql命令了:编辑 /etc/profile 
 在末尾添加`export PATH=$PAHT:/usr/local/mysql/bin`
 重启资源: `source /etc/profile`
17. root帐号初始密码为空,修改root帐号密码:`sudo ./bin/mysqladmin -u root password 'root'`

## 7.安装tomcat
参考: `http://blog.csdn.net/gyming/article/details/36060843`
1. 解压apache-tomcat-7.0.82.jar.gz到要安装的路径 `/usr/local/`
2. `cd /usr/local/apache-tomcat-7.0.82`
3. 启动tomcat `./bin/startup.sh`

## 2.安装java8并配置环境变量
* 安装java8
1. `sudo add-apt-repository ppa:webupd8team/java`添加ppa仓库
2. `sudo apt-get update`
3. `sudo apt-get install oracle-java8-installer`安装java8
>  java默认安装路径: /usr/lib/jvm/java-8-oracle
4. 修改默认JDK
* 可以安装设置默认jdk:`sudo apt-get install oracle-java8-set-default`
* 设置默认使用的jdk
`sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk8/bin/java 300`
`sudo update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/jdk8/bin/javac 300`


## 1.安装输入法
* 安装
1. `sudo apt-get install fcitx fcitx-config-gtk fcitx-sunpinyin fcitx-googlepinyin fcitx-module-cloudpinyin`
2. `sudo apt-get install fcitx-table-all`
3. 设置fcitx为默认输入法,重启.
* 遇到的问题及解决方法
1. 谷歌输入法中文时不显示候选词.
>原因:在非KDE桌面环境下，如果安装了fcitx-module-kimpanel，可能会导致Fcitx输入中文时不显示候选词框，移除该组件，然后重启Fcixt  <br>
解决:`sudo apt remove fcitx-module-kimpanel`


