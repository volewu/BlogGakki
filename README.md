# BlogGakki
wuvole.com(待开发ing......)



```
把 GitHub 仓库的语言设置为自己想要的

创建 .gitattributes 文件，并在里面输入以下代码，win 下直接命令行： touch .gitattributes 生成
*.js linguist-language=Java
*.css linguist-language=Java
*.html linguist-language=Java
```

解决failed to push some refs to git?
由于远程仓库与本地仓库存在差异，需要两者进行合并

git pull --rebase origin master
