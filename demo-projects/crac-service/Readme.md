# CRaC Service Spring Boot Example


## Installation notes

```shell
sudo chown root:root $JAVA_HOME/lib/criu
sudo chmod u+s $JAVA_HOME/lib/criu
```
## Recommentations

#### 1.  Do not run via the Makefile

For some reason, this does not seem to work if we run the executable via the Makefile on IntelliJ.
It might be related to how service discovery works.
Running the Makefile in the IDE creates some pointers that may confuse the whole process.

## Resources

-   [Runtime efficiency with Spring (today and tomorrow)](https://spring.io/blog/2023/10/16/runtime-efficiency-with-spring)
-   [Open JDK CRaC wiki](https://wiki.openjdk.org/display/crac)
-   [SpringBoot 3.2 + CRaC](https://foojay.io/today/springboot-3-2-crac/)
-   [CRIU on Wikipedia](https://en.wikipedia.org/wiki/CRIU)
-   [CRaC (Coordinated Restore at Checkpoint)](https://openjdk.org/projects/crac/)
-   [Introduction to Project CRaC: Enhancing Runtime Efficiency in Java & Spring Development](https://www.youtube.com/watch?v=sVXUx_Y4hRU)
-   [How to Run a Java Application with CRaC in a Docker Container](https://foojay.io/today/how-to-run-a-java-application-with-crac-in-a-docker-container/)
-   [Example Spring Boot with C.R.a.C.](https://github.com/CRaC/example-spring-boot)

## About me

[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=for-the-badge&logo=github&color=grey "GitHub")](https://github.com/jesperancinha)
