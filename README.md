# sharing-jdbc
#分库分表
#读写分离
gitignore 不起作用的原因
某些文件已经被纳入了版本管理中，就算是在.gitignore中已经声明了忽略路径也是不起作用的，这时候我们就应该先把本地缓存删除，然后再进行git的push，这样就不会出现忽略的文件了。git清除本地缓存命令如下:
git rm -r --cached .  
git add .
git commit -m "update gitignore"