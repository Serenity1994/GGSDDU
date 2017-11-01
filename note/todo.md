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

## 2.安装java8并配置环境变量
* 安装java8
1. `sudo add-apt-repository ppa:webupd8team/java`添加ppa仓库
2. `sudo apt-get update`
3. `sudo apt-get install oracle-java8-installer`安装java8
>  java默认安装路径: /usr/lib/jvm/java-8-openjdk-amd64
* 配置环境变量
1. 查看当前是否已经配置好环境变量(mint安装java时默认已经配置好环境变量了) 

## 1.安装输入法
* 安装
1. `sudo apt-get install fcitx fcitx-config-gtk fcitx-sunpinyin fcitx-googlepinyin fcitx-module-cloudpinyin`
2. `sudo apt-get install fcitx-table-all`
3. 设置fcitx为默认输入法,重启.
* 遇到的问题及解决方法
1. 谷歌输入法中文时不显示候选词.
>原因:在非KDE桌面环境下，如果安装了fcitx-module-kimpanel，可能会导致Fcitx输入中文时不显示候选词框，移除该组件，然后重启Fcixt  <br>
解决:`sudo apt remove fcitx-module-kimpanel`


