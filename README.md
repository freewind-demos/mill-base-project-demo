Mill Base Project Demo
======================

Install mill:

```
sudo curl -L -o /usr/local/bin/mill https://github.com/lihaoyi/mill/releases/download/0.1.0/0.1.0 && sudo chmod +x /usr/local/bin/mill
```

Run project:

```
mill hello.test
```

Generate IDEA project:

```
mill.scalalib.GenIdeaModule/idea
```
